package example.practice4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice4.dto.CourseDto;
import example.practice4.model.entity.CourseEntity;
import example.practice4.model.repository.CourseRepository;

@Service 
public class CourseService {
    @Autowired private CourseService courseService;

    // 1. 등록
    public boolean 과정등록( CourseDto courseDto ){
        CourseEntity courseEntity = courseDto.toEntity(); // 1. dto -> entity 변환
        CourseEntity savedEntity = CourseRepository.save( courseEntity ); // 2. entoty 저장하기
        if ( savedEntity.getCourseId() >= 1) return true;
    }
    // 2. 전체조회
    public List<CourseDto> 과정전체조회( ){
        // 1. findAll 전체조회
        List<CourseEntity> courseEntities = CourseRepository,findAll();
        courseEntities.forEach(courseEntity) -> {
            CourseDto courseDto = courseDto.from
        }
    }
}
