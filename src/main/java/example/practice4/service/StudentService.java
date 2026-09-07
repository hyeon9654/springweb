package example.practice4.service;

import example.practice4.model.repository.StudentRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice4.dto.StudentDto;
import example.practice4.model.entity.StudentEntity;

@Service 
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired private StudentService studentService;
    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }   
    // 1. 학생등록
    public boolean 학생등록( StudentDto StudentDto ){
        StudentEntity studentEntity = StudentDto.toEntity();
        StudentEntity savedEntity = StudentRepository.save( studentEntity );
        if (savedEntity.getStudentId() >= 1 ) return true;
        return false;
    }
    // 2. 학생삭제ㅣ PK가 삭제될 대 연관된 FK가 존재화면 제약조건 확인!!
    // JPA: cascade = CascadeType.REMOVE, SQL : on delete cascade
    public boolean 학생삭제( Integer studentId ) {
        // 1. 학생번호 이용한 학생 엔티티 찾기
        Optional<StudentEntity> optional = StudentRepository.findById(studentId);
        // 2. 만일 엔티티 존재하면
        if (optional.isPresent()) {
            studentRepository.deleteById( studentId );
            return true;
        }
        return false;
    }
}
