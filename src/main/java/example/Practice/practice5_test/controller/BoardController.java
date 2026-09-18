package example.practice5_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice5_test.service.BoardService;
import example.practice5_test.model.dto.BoardDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController @RequestMapping("/api/board")
public class BoardController {
    @Autowired private BoardService boardService;

    @PostMapping("")
    public boolean 게시물등록(@RequestBody BoardDto boardDto) {
        return boardService.게시물등록(boardDto);
    }

    @GetMapping("")
    public List<BoardDto> 게시물전체조회() {
        return boardService.게시물전체조회();
    }
    
    @DeleteMapping("")
    public boolean 게시물삭제(
        @RequestParam(name = "id")
        Integer id,
        @RequestParam(name = "password")
        String password){
    return boardService.게시물삭제(id, password);
        }
}
    