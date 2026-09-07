package example.practice4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.practice4.dto.CourseDto;
import example.practice4.service.CourseService;
import jakarta.persistence.PostRemove;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("api/couse")
public class CourseController {
    @Autowired private CourseService courseService;

    @PostMapping("")
    public boolean 과정등록( 
        @RequestBody CourseDto courseDto ){
        return courseService.과정등록( courseDto );
    }

    @GetMapping("")
    public List<CourseDto> 과정전체조회( ){
        return courseService.과정전체조회();
    }
}
