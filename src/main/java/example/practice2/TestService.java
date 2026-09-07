package example.practice2;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;


    // [1] 게시물 등록
    public boolean testWriter(TestEntity entity) {
        TestEntity savedEntity = testRepository.save(entity);
        if(savedEntity.getNo() != null) {
            return true;
        }
        return false;
    }


    // [2] 게시물 전체조회
    public List<TestEntity> testPrint() {
        return testRepository.findAll();
    }


    // [3] 게시물 개별조회
    public TestEntity testDetail(int no) {
        Optional<TestEntity> optional =
                testRepository.findById(no);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    // [4] 게시물 삭제
    public boolean testDelete(int no) {
        boolean result = testRepository.existsById(no);
        if(result == true) {
            testRepository.deleteById(no);
            return true;
        }
        return false;
    }


    // [5] 게시물 수정
    @Transactional
    public boolean testUpdate(TestEntity entity) {
        Optional<TestEntity> optional =
                testRepository.findById(entity.getNo());
        if(optional.isPresent()) {
            TestEntity savedEntity = optional.get();
            savedEntity.setContent(entity.getContent());
            return true;
        }
        return false;
    }

}