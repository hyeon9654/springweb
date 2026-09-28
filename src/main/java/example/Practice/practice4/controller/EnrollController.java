package example.Practice.practice4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.Practice.practice4.model.dto.EnrollDto;
import example.Practice.practice4.service.EnrollService;

@RestController
@RequestMapping("/api/enroll")
public class EnrollController {

    @Autowired private EnrollService enrollService;

    // 1. 수강등록
    @PostMapping("")
    public boolean 수강등록(
        @RequestBody EnrollDto enrollDto ){

        return enrollService.수강등록( enrollDto );
    }

    // 2. 수강번호 조회
    // http://localhost:8080/api/enroll?enrollId=1
    @GetMapping("")
    public EnrollDto 수강조회(
        @RequestParam(name = "enrollId") Integer enrollId ){

        return enrollService.수강조회( enrollId );
    }
}