package example.practice5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.practice5.service.CommentService;

@RestController @RequestMapping ("/api/comment")
public class CommentController {
    @Autowired private CommentService commentService;
}
