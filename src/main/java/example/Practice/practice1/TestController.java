package example.Practice.practice1;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 게시물들을 저장할 리스트
    private ArrayList<TestDto> list = new ArrayList<>();

    // 게시물 번호 자동증가용
    private int no = 1;

    // 1. 게시물 등록
    // POST /test
    @PostMapping("/test")
    public boolean testWrite(
            @RequestBody TestDto testDto) {
        testDto.setNo(no);
        list.add(testDto);
        no++;
        return true;
    }

    // 2. 게시물 전체조회
    // GET /test
    @GetMapping("/test")
    public ArrayList<TestDto> testPrint() {
        return list;
    }

    // 3. 게시물 개별조회
    // GET /test/detail?bno=1
    @GetMapping("/test/detail")
    public TestDto testDetail(
            @RequestParam(name = "bno") int no) {
        for (int i = 0; i < list.size(); i++) {
            TestDto testDto = list.get(i);
            if (testDto.getNo() == no) {
                return testDto;
            }
        }
        return null;
    }

    // 4. 게시물 삭제
    // DELETE /test?bno=1
    @DeleteMapping("/test")
    public boolean testDelete(
            @RequestParam(name = "bno") int no) {
        for (int i = 0; i < list.size(); i++) {
            TestDto testDto = list.get(i);
            if (testDto.getNo() == no) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    // 5. 게시물 수정
    // PUT /test
    @PutMapping("/test")
    public boolean testUpdate(
            @RequestBody TestDto testDto) {
        for (int i = 0; i < list.size(); i++) {
            TestDto dto = list.get(i);
            if (dto.getNo() == testDto.getNo()) {
                dto.setContent(testDto.getContent());
                return true;
            }
        }
        return false;
    }
}