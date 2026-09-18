package example.practice2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository
        // extends JpaRepository< 조작할엔티티명, 조작할엔티티PK타입 >
        // 1. 기본 CRUD 제공 받는다. save( ), findById( ), findAll, deleteById( )
        // 2. 

extends JpaRepository<TestEntity, Integer> {

}