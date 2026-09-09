package example.practice5_test.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table (name = "board")
@NoArgsConstructor @AllArgsConstructor @Builder 
@Getter @Setter  
public class CommentEntity extends BaseTime {
    
    // 1. 댓글 번호 PK
    @Id 
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;

    // 2. 작성자
    @Column(nullable = false)
    private String author;

    // 3. 비밀번호
    @Column(nullable = false)
    private String password;
    // 4. 내용
    @Column(nullable = false)
    private String content;
    // 5. 댓글 N : 게시글 1
    @ManyToOne 
    @JoinColumn( name = "board_id" )
    private BoardEntity boardEntity;
}
