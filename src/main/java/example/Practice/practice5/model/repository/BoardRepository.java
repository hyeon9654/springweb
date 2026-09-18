package example.practice5.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.practice5.model.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
}