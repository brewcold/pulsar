package com.hammer.pulsar.service;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.member.MemberProfile;
import com.hammer.pulsar.dto.routine.Routine;

import java.util.List;

// 루틴 관련 로직을 처리할 서비스의 인터페이스
public interface RoutineService {
    // 루틴 주인 프로필을 조회하는 로직
    public MemberProfile getMemberProfile(int routineId);

    // 루틴을 추가하는 로직
    public int addNewRoutine(NotDetermined routine);

    // 회원의 루틴을 조회하는 로직
    public List<Routine> getAllRoutines(int memberId);

    // 선택한 루틴을 상세조회 하는 로직
    public Routine getRoutineDetail(int routineId);

    // 선택한 루틴을 수정하는 로직
    public void modifyRoutineInfo(NotDetermined routine);

    // 선택한 루틴을 삭제하는 로직
    public void removeRoutine(int routineId);

    // 루틴에 운동 계획을 추가하는 로직
    public void addNewPlan(NotDetermined exercise);

    // 루틴의 운동 계획을 수정하는 로직
    public void modifyPlan(NotDetermined exercise);

    // 루틴의 운동 계획을 삭제하는 로직
    public void removePlan(NotDetermined exercise);

}
