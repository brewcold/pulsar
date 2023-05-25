package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.DayDao;
import com.hammer.pulsar.dao.RoutineDao;
import com.hammer.pulsar.dao.RoutineDetailDao;
import com.hammer.pulsar.dto.member.MemberProfile;
import com.hammer.pulsar.dto.routine.*;
import com.hammer.pulsar.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// 실제 로직이 구현된 RoutineService 인터페이스의 구현체 클래스
@Service
public class RoutineServiceImpl implements RoutineService {
    private final RoutineDao routineDao;
    private final RoutineDetailDao routineDetailDao;
    private final DayDao dayDao;

    @Autowired
    public RoutineServiceImpl(RoutineDao routineDao, RoutineDetailDao routineDetailDao, DayDao dayDao) {
        this.routineDao = routineDao;
        this.routineDetailDao = routineDetailDao;
        this.dayDao = dayDao;
    }

    /**
     * 루틴 고유번호로 루틴 작성자의 프로필 정보를 조회하는 메서드
     *
     * @param routineId
     * @return
     */
    @Override
    public MemberProfile getMemberProfile(int routineId) {
        return routineDao.selectProfileByRoutineId(routineId);
    }

    /**
     * 새로운 루틴을 추가하는 메서드
     *
     * @param form
     * @return
     */
    @Override
    @Transactional
    public int addNewRoutine(RoutineRegistForm form, int memberId) {
        RoutineRegistRequest request = new RoutineRegistRequest(form);
        request.setWriterId(memberId);

        routineDao.insertRoutine(request);

        // 루틴 요일정보 추가
        DayUpdateRequest dayUpdateRequest = convertToDayUpdateRequest(form.getTime().getRepeatDay());
        dayUpdateRequest.setRoutineId(request.getRoutineNo());

        dayDao.insertRoutineDay(dayUpdateRequest);

        return request.getRoutineNo();
    }

    // ("day", "week", "month") -> ("일", "주", "월") 변환하는 메서드
    private String convertRoutineUnit(String repeatUnit) {
        if(repeatUnit.equals("day")) {
            return "일";
        } else if(repeatUnit.equals("week")) {
            return "주";
        } else {
            return "월";
        }
    }

    // 값이 true인 요일을 문자열 리스트에 담아서 반환
    private List<String> convertRoutineDay(RoutineDay routineDay) {
        List<String> converted = new ArrayList<>();

        if(routineDay.isSun()) converted.add("일");
        if(routineDay.isMon()) converted.add("월");
        if(routineDay.isTue()) converted.add("화");
        if(routineDay.isWed()) converted.add("수");
        if(routineDay.isThu()) converted.add("목");
        if(routineDay.isFri()) converted.add("금");
        if(routineDay.isSat()) converted.add("토");

        return converted;
    }

    /**
     * 회원의 모든 루틴 목록을 조회하는 메서드
     *
     * @param memberId
     * @return
     */
    @Override
    public List<Routine> getAllRoutines(int memberId) {
        List<Routine> routines = routineDao.selectRoutinesByMemberId(memberId);

        // 불러온 각 루틴마다 운동목록과 루틴요일을 추가하기
        for(Routine routine : routines) {
            // 루틴의 운동 세부계획을 추가
            routine.setExerciseList(routineDetailDao.selectExercisesByRoutineId(routine.getRoutineNo()));
            // 루틴 일정정보를 쉽게 변환
            routine.getTime().setRepeatUnit(convertRoutineUnit(routine.getTime().getRepeatUnit()));
            routine.getTime().setRepeatDay(convertRoutineDay(dayDao.selectRoutineDay(routine.getRoutineNo())));
        }

        return routines;
    }

    /**
     * 선택한 루틴의 상세 정보를 조회하는 메서드
     * 만약 루틴의 작성자와 조회 요청한 memberId가 다르면 401 UNAUTHORIZED
     *
     * @param routineId
     * @return
     */
    @Override
    public Routine getRoutineDetail(int routineId, int memberId) {
        Routine routine = routineDao.selectRoutineByRoutineId(routineId);

        if(routine == null) throw new NoSuchElementException("존재하지 않는 루틴입니다.");
        if(routine.getMemberNo() != memberId) throw new UnauthorizedException("권한이 없습니다.");

        // 루틴의 운동 세부계획을 추가
        routine.setExerciseList(routineDetailDao.selectExercisesByRoutineId(routineId));
        // 루틴 일정정보를 변환
        routine.getTime().setRepeatUnit(convertRoutineUnit(routine.getTime().getRepeatUnit()));
        routine.getTime().setRepeatDay(convertRoutineDay(dayDao.selectRoutineDay(routineId)));

        return routine;
    }

    /**
     * 선택한 루틴 정보를 수정하는 메서드
     * 만약 루틴의 작성자와 수정 요청한 memberId가 다르면 401 UNAUTHORIZED
     *
     * @param form
     * @param memberId
     */
    @Override
    @Transactional
    public void modifyRoutineInfo(RoutineModifyForm form, int memberId) {
        if(routineDao.selectRoutineByRoutineId(form.getRoutineId()).getMemberNo() != memberId) {
            throw new UnauthorizedException("권한이 없습니다.");
        }

        // 루틴 내용 수정
        routineDao.updateRoutine(new RoutineModifyRequest(form));

        // 루틴 요일정보 수정
        DayUpdateRequest dayUpdateRequest = convertToDayUpdateRequest(form.getTime().getRepeatDay());
        dayUpdateRequest.setRoutineId(form.getRoutineId());

        dayDao.updateRoutineDay(dayUpdateRequest);

        ExerciseRegistRequest request = new ExerciseRegistRequest();
        request.setRoutineId(form.getRoutineId());
        request.setExerciseList(form.getExerciseList());

        // 루틴 세부 계획 수정
        updateExerciseList(request);
    }

    // 루틴의 세부 계획을 교체하는 메서드
    // TODO: equals, hashcode를 이용해서 변한 것만 수정하도록 바꿔보기
    private void updateExerciseList(ExerciseRegistRequest request) {
        routineDetailDao.deleteExercises(request.getRoutineId());
        routineDetailDao.insertExercises(request);
    }

    // 클라이언트로부터 입력받은 요일 정보 배열을 쿼리에 필요한 형식으로 변환
    private DayUpdateRequest convertToDayUpdateRequest(List<String> repeatDay) {
        DayUpdateRequest request = new DayUpdateRequest();

        for(String day : repeatDay) {
            switch (day) {
                case "mon":
                    request.setMon(true);
                    break;
                case "tue":
                    request.setTue(true);
                    break;
                case "wed":
                    request.setWed(true);
                    break;
                case "thu":
                    request.setThu(true);
                    break;
                case "fri":
                    request.setFri(true);
                    break;
                case "sat":
                    request.setSat(true);
                    break;
                case "sun":
                    request.setSun(true);
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        return request;
    }

    /**
     * 선택한 루틴을 삭제하는 메서드
     * 만약 루틴의 작성자와 삭제 요청한 memberId가 다르면 401 UNAUTHORIZED
     *
     * @param routineId
     */
    @Override
    @Transactional
    public void removeRoutine(int routineId, int memberId) {
        if(routineDao.selectRoutineByRoutineId(routineId).getMemberNo() != memberId) {
            throw new UnauthorizedException("권한이 없습니다.");
        }

        if(routineDao.deleteRoutine(routineId) == 0) throw new NoSuchElementException("존재하지 않는 루틴입니다.");
    }

}
