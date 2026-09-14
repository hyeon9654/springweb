package example.practice5.model.dto;

import java.time.LocalDateTime;

import example.practice5.model.entity.BoardEntity;
import example.practice5.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

 	
@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class CommentDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    // + BASETIME
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // + FK 
    private Integer boardId;
    // 
    public CommentEntity toEntity( BoardEntity boardEntity ){
        return CommentEntity.builder()
            .content( this.content )
            .password( this.password )
            .author( this.author )
            .boardEntity( boardEntity )
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
            .boardId( entity.getBoardEntity().getId() )
            .build();
    }
}