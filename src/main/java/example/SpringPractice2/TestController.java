package example.SpringPractice2;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;


    // [1] 게시물 등록
    // POST /test
    @PostMapping("")
    public boolean testWriter(
            @RequestBody TestEntity entity) {
        return testService.testWriter(entity);
    }


    // [2] 게시물 전체조회
    // GET /test
    @GetMapping("")
    public List<TestEntity> testPrint() {
        return testService.testPrint();
    }


    // [3] 게시물 개별조회
    // GET /test/detail?no=1
    @GetMapping("/detail")
    public TestEntity testDetail(
            @RequestParam("no") int no) {
        return testService.testDetail(no);
    }


    // [4] 게시물 삭제
    // DELETE /test?no=1
    @DeleteMapping("")
    public boolean testDelete(
            @RequestParam("no") int no) {
        return testService.testDelete(no);
    }

    // [5] 게시물 수정
    // PUT /test
    @PutMapping("")
    public boolean testUpdate(
            @RequestBody TestEntity entity) {

        return testService.testUpdate(entity);
    }
}