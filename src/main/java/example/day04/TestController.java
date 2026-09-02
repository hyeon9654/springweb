package example.day04;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController // @RestController: http(응답) content-type: application/json + @Controller
// 주로 뷰 반환: @Controller, 값 반환: @RestController
@RequestMapping( "/day04" ) // *클래스내 메소드들의 공통URL 정의

public class TestController {
    // [1] 게시물 등록
    @PostMapping("/") // 상위(클래스)에 "/test" 주소가 정의됨
    public boolean testWriter( @RequestBody TestDto testDto ){
        return true;    // 임의로 반환 성공
    }

    // [2] 게시물 전체조회
    @GetMapping("")
    public ArrayList<TestDto> testPrint( ) { System.out.println("TestController,testPrint()"); 
    ArrayList<TestDto> list = new ArrayList<>();
    list.add( new TestDto(1,"내용1","작성자1"));
    list.add( new TestDto(2,"내용2","작성자2"));
    return list;
}
    // [3] 게시물 개별조회
    @GetMapping("/detail")
    public TestDto testDetail(@RequestParam ("no") int no ) { System.out.println( "TestController.testDetail()");
        return new TestDto( 1, "내용1", "작성자1");
    }

    // [4] 게시물 삭제
    @DeleteMapping("/{no}")
    public boolean testDelete(@PathVariable("no") int no) {
        System.out.println("TestController.testDelete()");
        return true;
    }
    
    // [5] 게시물 수정
    @PutMapping("")
    public boolean testUpdate( @RequestBody TestDto testDto ){System.out.println("TestController.testUpdate()");
        return true;
    }
} // class end

@Data   // getter setter toString 등등
@AllArgsConstructor @NoArgsConstructor @Builder
class TestDto{ 
    private int no; 
    private String writer;
    private String content; 
}

/*
    -int : 기본타입 +- 21억저장
    - Intger: 참조타입 ( int 객체클래스 ) + null(없다뜻) 저장
    주의할점: HTTP 파싱하는 경우에 int에는 NULL 저장 불가능
    권장1ㅣ 기본타입 대신에 래퍼타입 사용하자.
*/