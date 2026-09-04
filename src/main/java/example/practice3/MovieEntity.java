package example.practice3;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // 데이터베이스 테이블과 매핑 관계
@Table( name = "movie" )    // 테이블 지정
@Getter@Setter@ToString@Builder@NoArgsConstructor@AllArgsConstructor    // 롬복
public class MovieEntity {
    @Id // PK
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer movieid;

    @Column( nullable = false ) // not null
    private String title;

    @Column( length = 100 ) // varchar(100)
    private String director;
    private LocalDate releasedate;
    private Double rating;
    public LocalDate getCreateDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCreateDate'");
    }
    public LocalDateTime getUpdateDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUpdateDate'");
    }
}
