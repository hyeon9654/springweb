package example.practice5_test.model.entity;

import java.util.ArrayList;
import java.util.List;

import example.practice5.model.entity.CommentEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity@Table(name = "board")
@NoArgsConstructor@AllArgsConstructor@Builder
@Getter@Setter
public class BoardEntity extends BaseTime{
    // 1. 게시물 등록
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    // 2. 작성자
    @Column(nullable = false , length = 50)
    private String author;

    // 3. 비밀번호
    @Column(nullable = false, length = 100)
    private String password;

    // 4. 내용
    @Column(nullable = false , columnDefinition = "TEXT")
    private String content;

    // 5. 게시글 1 : 댓글 N
    @OneToMany(
        mappedBy = "boardEntity", cascade = CascadeType.ALL
    )
    @Builder.Default
    private List<CommentEntity> comments = new ArrayList<>();
}
