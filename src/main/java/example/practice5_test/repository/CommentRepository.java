package example.practice5_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.practice5_test.model.entity.BoardEntity;

@Repository 
public interface CommentRepository extends JpaRepository<BoardEntity,Integer>{
   
}