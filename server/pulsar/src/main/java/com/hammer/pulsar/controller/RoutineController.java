package com.hammer.pulsar.controller;

import com.hammer.pulsar.service.InteractionService;
import com.hammer.pulsar.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 루틴 관련 API 요청을 처리할 REST 컨트롤러
@RestController
@RequestMapping("/routines")
public class RoutineController {

    // 루틴 관련 서비스 로직을 처리할 클래스
    private final RoutineService routineService;

    // 컨트롤러의 생성자
    @Autowired
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }
}
