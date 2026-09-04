package example.day06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table( name = "category" )
@Data@NoArgsConstructor @AllArgsConstructor 
public class CategoryEntity {
    @Id 
    private  Integer cno;
    private  String cname;
    // 양방향 참조
    @OneToOne
    private List<BoardEntity> boardList = new ArrayList<>()

}
