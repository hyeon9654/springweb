package example.practice5_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5.model.repository.CommentRepository;

@Service 
public class CommentSrvice {
    @Autowired private CommentRepository commentRepository;
}
