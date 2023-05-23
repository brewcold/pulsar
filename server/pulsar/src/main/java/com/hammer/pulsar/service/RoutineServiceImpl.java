package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.DayDao;
import com.hammer.pulsar.dao.MemberDao;
import com.hammer.pulsar.dao.RoutineDao;
import com.hammer.pulsar.dao.RoutineDetailDao;
import com.hammer.pulsar.dto.member.MemberProfile;
import com.hammer.pulsar.dto.routine.*;
import com.hammer.pulsar.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int addNewRoutine(RoutineRegistForm form, int memberId) {
        RoutineRegistRequest request = new RoutineRegistRequest(form);
        request.setWriterId(memberId);

        return routineDao.insertRoutine(request);
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
            routine.setExerciseList(routineDetailDao.selectExercisesByRoutineId(routine.getRoutineNo()));
            routine.getTime().setRepeatDay(dayDao.selectRoutineDay(routine.getRoutineNo()));
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

        routine.setExerciseList(routineDetailDao.selectExercisesByRoutineId(routineId));
        routine.getTime().setRepeatDay(dayDao.selectRoutineDay(routineId));

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
    public void modifyRoutineInfo(RoutineModifyForm form, int memberId) {
        if(routineDao.selectRoutineByRoutineId(form.getRoutineId()).getMemberNo() != memberId) {
            throw new UnauthorizedException("권한이 없습니다.");
        }

        routineDao.updateRoutine(new RoutineModifyRequest(form));
    }

    /**
     * 선택한 루틴을 삭제하는 메서드
     * 만약 루틴의 작성자와 삭제 요청한 memberId가 다르면 401 UNAUTHORIZED
     *
     * @param routineId
     */
    @Override
    public void removeRoutine(int routineId, int memberId) {
        if(routineDao.selectRoutineByRoutineId(routineId).getMemberNo() != memberId) {
            throw new UnauthorizedException("권한이 없습니다.");
        }

        if(routineDao.deleteRoutine(routineId) == 0) throw new NoSuchElementException("존재하지 않는 루틴입니다.");
    }

}
