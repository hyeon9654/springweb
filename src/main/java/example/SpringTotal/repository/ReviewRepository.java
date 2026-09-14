package example.SpringTotal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.SpringTotal.model.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{
    
}
