package example.day06;

import example.practice5_test.model.dto.BoardDto.BoardDtoBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity@Table( name = "board" ) 
@NoArgsConstructor @AllArgsConstructor
public class BoardEntity {
    @Id
    private Integer bno;
    private String bname;

    // 단방향 참조 FK, 자바에서는 멤버변수가 Entity이지만 DB에서는 fk만 제공
    @ManyToOne // 다수가 하나에게 참조
    @JoinColumn( name = "cno" )    // FK이름 지정, 주로 pk와 동일하게
    private CategoryEntity categoryEntity;

    public Object getAuthor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthor'");
    }

    public Integer getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public static BoardDtoBuilder builder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'builder'");
    }
    
}
