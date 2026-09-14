package example.SpringTotal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.SpringTotal.model.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
    
}
