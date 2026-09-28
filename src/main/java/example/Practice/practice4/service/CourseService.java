package example.Practice.practice4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice.practice4.model.dto.CourseDto;
import example.Practice.practice4.model.dto.StudentDto;
import example.Practice.practice4.model.entity.CourseEntity;
import example.Practice.practice4.model.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired private CourseRepository courseRepository;

    // 1. 등록
    public boolean 과정등록( CourseDto courseDto ){
        CourseEntity courseEntity = courseDto.toEntity(); // 1. dto -> entity 변환
        CourseEntity savedEntity = courseRepository.save( courseEntity ); // 2. entity 저장하기
        if ( savedEntity.getCourseId() >= 1) return true;
        return false;
    }

    // 2. 전체조회
    public List<CourseDto> 과정전체조회( ){
        // 1. findAll 전체조회
        List<CourseEntity> courseEntities = courseRepository.findAll();

        List<CourseDto> list = new ArrayList<>();

        courseEntities.forEach( (courseEntity) -> {
            CourseDto courseDto = CourseDto.from( courseEntity );

            // 과정별 수강생 목록
            List<StudentDto> studentDtos = new ArrayList<>();

            courseEntity.getEnrollEntities().forEach( (enrollEntity) -> {
                StudentDto studentDto =
                        StudentDto.from( enrollEntity.getStudentEntity() );

                studentDtos.add( studentDto );
            });

            courseDto.setStudentDtos( studentDtos );

            list.add( courseDto );
        });

        return list;
    }
}