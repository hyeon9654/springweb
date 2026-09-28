package example.practice5_test.model.dto;

import java.time.LocalDateTime;

import example.practice5.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Builder
@Data @Getter @Setter 
public class CommentDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer boardId;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
            .content( this.content )
            .password( this.password )
            .author( this.author )
            .build();
    }
    //
    public static CommentDto from( CommentEntity entity ){
        return CommentDto.builder()
            .id( entity.getId() )
            .author( entity.getAuthor() )
            .password( entity.getPassword() )
            .content( entity.getContent() )
            .createdAt( entity.getCreatedAt() )
            .updatedAt( entity.getUpdatedAt() )
            .build();
    }
}