package example.day05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import jakarta.transaction.Transactional;

@Service
public class TestService {
    @Autowired private TestRepository testRepository;

    // 1. 전체조회
    public List<TestDto> 전체조회( ){
        // 1. 모든 엔티티 조회한다.
        List<TestEntity> entities = testRepository.findAll();
        // 2. 모든 엔티티 -> DTO 변환하기
        // 빈 리스트 생성
        List<TestDto> list = new ArrayList<>();
        // 모든 엔티티 반복하여 DTO로 변환하여 새로운 리스트 저장
        entities.forEach( (entity) -> {
            // 리스트 내 하나씩 entity(반복변수)에 대입 반복
            // - TestDto내 entity -> Dto 변환함수 : from
            TestDto dto = TestDto.from( entity );
            // - 변환 결과 새로운 리스트에 담기
            list.add( dto );
        }); return list;
    }
    // 2. 저장
    public boolean 저장( TestDto testDto ){
        // 1. dto --> entity 변환함수 : toEntity 함수
        TestEntity testEntity = testDto.toEntity();
        // 2. entity save 저장
        TestEntity savedEntity = testRepository.save( testEntity );
        // 3. 
        if ( savedEntity.getNo() >= 1 ) { return true; }
        return false;
    }

    // 3. 수정
    @Transactional
    public boolean 수정(TestDto testDto) {

    // 1. 수정할 번호(PK)로 기존 엔티티 조회
    Optional<TestEntity> optional =
            testRepository.findById(testDto.getNo());

    // 2. 해당 번호의 엔티티가 존재하는지 확인
    if(optional.isPresent()) {

        // 3. 영속 상태의 엔티티 꺼내기
        TestEntity entity = optional.get();

        // 4. 수정할 값 변경
        entity.setName(testDto.getName());
        entity.setDescri(testDto.getDescri());
        entity.setPrice(testDto.getPrice());

        // @Transactional 때문에
        // 별도의 save() 없이 UPDATE SQL 자동 실행

        return true;
    }

    return false;
}

}
