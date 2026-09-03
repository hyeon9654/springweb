package example.day05;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.cglib.core.Local;

@NoArgsConstructor@AllArgsConstructor@Builder@Setter@Getter

public class TestDto {
    private Integer no;
    private String name;
    private String descri;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    // DTO ---> ENTITY 함수 : C -> S( D -> E ) , toEntity( )
    // this란? 해당 메소드 호출한 인스턴스 가리킴.
    public TestEntity toEntity( ){
        return TestEntity.builder() // 빌더패턴이란? new(생성자) 대신에 객체 생성을 메소드 방식 지원
            .name(this.name)
            .descri(this.descri)
            .price(this.price)
            .build();    // 빌더패턴 끝
    }
    // ENTITY ---> DTO 함수 : S -> C( E -> D ) , from(Entity entity), 주로 fincd
    // static 이란? 인스턴스 없이 호출가능 메소드/변수
    // static 에는 this 없을까? 인스턴스없이 사용하는 메소드
    public static TestDto from( TestEntity testEntity ){
        return TestDto.builder() 
            .name(testEntity.getName() )
            .descri(testEntity.getDescri() )
            .price(testEntity.getPrice() )
            .createDate(testEntity.getCreateDate() )
            .updateDate(testEntity.getUpdateDate() )
            .no(testEntity.getNo() )
        .build();
    }
}
