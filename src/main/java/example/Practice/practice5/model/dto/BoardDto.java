package example.practice5.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.practice5.model.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class BoardDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Builder.Default
    private List<CommentDto> comments = new ArrayList<>();

    // DTO → Entity
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .author(this.author)
                .password(this.password)
                .content(this.content)
                .build();
    }
    // Entity → DTO
    public static BoardDto from(BoardEntity entity) {
        return BoardDto.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}