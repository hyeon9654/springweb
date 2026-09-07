package example.practice5.model.entity;

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

@Entity@Table(name = "comment")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Builder
public class CommentEntity extends BaseTime {

    // 1. 댓글 번호 PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 2. 작성자
    @Column(nullable = false, length = 50)
    private String author;

    // 3. 비밀번호
    @Column(nullable = false, length = 100)
    private String password;

    // 4. 댓글 내용
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 5. 이 댓글이 속한 게시글
    @ManyToOne
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;
}