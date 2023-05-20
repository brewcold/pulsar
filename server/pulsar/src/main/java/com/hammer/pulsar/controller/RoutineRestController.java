package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.NotDetermined;
import com.hammer.pulsar.dto.routine.Routine;
import com.hammer.pulsar.dto.routine.RoutineModifyForm;
import com.hammer.pulsar.dto.routine.RoutineRegistForm;
import com.hammer.pulsar.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<Integer> addNewRoutine(RoutineRegistForm form, HttpServletRequest request) {
        // 로그인 회원의 고유번호
        // TODO: 회원번호를 가져온 것은 임시코드이므로 로그인 구현시 수정할 것
        int memberId = (Integer) request.getSession().getAttribute("memberId");

        int routineNo = routineService.addNewRoutine(form, memberId);

        // 작성한 루틴의 고유 번호를 응답으로 보낸다.
        return new ResponseEntity<>(routineNo, HttpStatus.CREATED);
    }

    // 루틴 수정 API
    @PutMapping("/routine/{routineId}")
    public ResponseEntity<Void> modifyRoutineInfo(@PathVariable int routineId, RoutineModifyForm form) {
        form.setRoutineId(routineId);
        routineService.modifyRoutineInfo(form);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 루틴 삭제 API
    @DeleteMapping("/routine/{routineId}")
    public ResponseEntity<Void> removeRoutine(@PathVariable int routineId) {
        routineService.removeRoutine(routineId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
