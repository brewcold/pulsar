package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.ExerciseDao;
import com.hammer.pulsar.dao.MemberDao;
import com.hammer.pulsar.dao.RoutineDao;
import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.member.MemberProfile;
import com.hammer.pulsar.dto.routine.Routine;
import com.hammer.pulsar.dto.routine.RoutineRegistForm;
import com.hammer.pulsar.dto.routine.RoutineRegistRequest;

import java.util.List;

public class RoutineServiceImpl implements RoutineService {
    private MemberDao memberDao;
    private RoutineDao routineDao;
    private ExerciseDao exerciseDao;

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
        return routineDao.selectRoutinesByMemberId(memberId);
    }

    /**
     * 선택한 루틴의 상세 정보를 조회하는 메서드
     *
     * @param routineId
     * @return
     */
    @Override
    public Routine getRoutineDetail(int routineId) {
        return routineDao.selectRoutineByRoutineId(routineId);
    }

    @Override
    public void modifyRoutineInfo(NotDetermined routine) {

    }

    /**
     * 선택한 루틴을 삭제하는 메서드
     *
     * @param routineId
     */
    @Override
    public void removeRoutine(int routineId) {
        routineDao.deleteRoutine(routineId);
    }

}
