package example.practice5_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice5.model.dto.CommentDto;
import example.practice5.service.CommentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController @RequestMapping("/api/board/comments")
public class CommentController {
    @Autowired private CommentService commentService;

    // 1. 댓글등록
    @PostMapping("")
    public boolean 댓글등록(@RequestBody CommentDto commentDto) {
        return commentService.댓글등록(commentDto);
    }

    // 2. 댓글삭제
    @DeleteMapping("")
    public boolean 댓글삭제(
        @RequestParam(name = "commendId")
        Integer commentId,
        @RequestParam(name = "password" )
        String password){
        return commentService.댓글삭제(commentId, password);
        }  
}
