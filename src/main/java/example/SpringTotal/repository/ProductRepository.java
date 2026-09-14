package example.SpringTotal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.SpringTotal.model.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
    
}
