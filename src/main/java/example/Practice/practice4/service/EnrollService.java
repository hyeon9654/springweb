package example.Practice.practice4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice.practice4.model.dto.EnrollDto;
import example.Practice.practice4.model.entity.CourseEntity;
import example.Practice.practice4.model.entity.EnrollEntity;
import example.Practice.practice4.model.entity.StudentEntity;
import example.Practice.practice4.model.repository.CourseRepository;
import example.Practice.practice4.model.repository.EnrollRepository;
import example.Practice.practice4.model.repository.StudentRepository;

@Service
public class EnrollService {
    @Autowired private EnrollRepository enrollRepository;
    @Autowired private CourseRepository courseRepository;
    @Autowired private StudentRepository studentRepository;

    // 1. 수강등록
    public boolean 수강등록( EnrollDto enrollDto ){

        // 1. DTO -> Entity
        EnrollEntity enrollEntity = enrollDto.toEntity();

        // 2. 과정번호로 과정 엔티티 찾기
        CourseEntity courseEntity =
                courseRepository.findById( enrollDto.getCourseId() ).orElse(null);

        // 3. 학생번호로 학생 엔티티 찾기
        StudentEntity studentEntity =
                studentRepository.findById( enrollDto.getStudentId() ).orElse(null);

        // 4. 과정 또는 학생이 없으면 등록 실패
        if( courseEntity == null || studentEntity == null ){
            return false;
        }

        // 5. FK 연결
        enrollEntity.setCourseEntity( courseEntity );
        enrollEntity.setStudentEntity( studentEntity );

        // 6. 저장
        EnrollEntity savedEntity = enrollRepository.save( enrollEntity );

        if( savedEntity.getEnrollId() >= 1 ){
            return true;
        }

        return false;
    }

    // 2. 수강번호 조회
    public EnrollDto 수강조회( Integer enrollId ){

        // 1. 수강번호 이용한 엔티티 찾기
        EnrollEntity enrollEntity =
                enrollRepository.findById( enrollId ).orElse(null);

        // 2. 없으면 null
        if( enrollEntity == null ){
            return null;
        }

        // 3. Entity -> DTO
        return EnrollDto.from( enrollEntity );
    }
}