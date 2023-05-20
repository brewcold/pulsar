package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.routine.Routine;
import com.hammer.pulsar.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 루틴 관련 API 요청을 처리할 REST 컨트롤러
@RestController
@RequestMapping("/routines")
public class RoutineRestController {

    // 루틴 관련 서비스 로직을 처리할 클래스
    private final RoutineService routineService;

    // 컨트롤러의 생성자
    @Autowired
    public RoutineRestController(RoutineService routineService) {
        this.routineService = routineService;
    }

    // 루틴 리스트 요청 API
    @GetMapping("/{memberId}")
    public ResponseEntity<List<Routine>> showAllRoutines(@PathVariable int memberId) {
        List<Routine> allRoutine = routineService.getAllRoutines(memberId);

        return new ResponseEntity<>(allRoutine, HttpStatus.OK);
    }

    // 루틴 상세보기 요청 API
    @GetMapping("/routine/{routineId}")
    public ResponseEntity<Routine> showRoutine(@PathVariable int routineId) {
        Routine routine = routineService.getRoutineDetail(routineId);

        return new ResponseEntity<>(routine, HttpStatus.OK);
    }

    // 루틴 작성 API
    @PostMapping("/routine")
    public ResponseEntity<Integer> addNewRoutine(NotDetermined request) {
        return null;
    }

    // routineNo을 REQ에 포함하고 URI를 /routine 으로 변경하는 것이 깔끔해 보입니다.
    // 루틴 수정 API
    @PutMapping("/routine/{routineId}")
    public ResponseEntity<Void> modifyRoutineInfo(@PathVariable int routineId, NotDetermined request) {
        return null;
    }

    // 루틴 삭제 API
    @DeleteMapping("/routine/{routineId}")
    public ResponseEntity<Void> removeRoutine(@PathVariable int routineId) {
        return null;
    }

    // URI를 routine/plan 으로 변경하는 것도 깔끔할 것 같습니다.
    // 운동 계획 작성 API
    @PostMapping("/routine/{routineId}")
    public ResponseEntity<Void> addNewPlan(@PathVariable int routineId) {
        return null;
    }

    // 운동 계획 수정 API
    @PutMapping("/routine/{routineId}/{exerciseId}")
    public ResponseEntity<Void> modifyPlan(@PathVariable int routineId, @PathVariable int exerciseId) {
        return null;
    }

    // 운동 계획 삭제 API
    @DeleteMapping("/routine/{routineId}/{exerciseId}")
    public ResponseEntity<Void> removePlan(@PathVariable int routineId, @PathVariable int exerciseId) {
        return null;
    }

}
