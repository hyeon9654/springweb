package example.practice5_test.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.day06.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


 	
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
    public BoardEntity toEntity(){
        return BoardEntity.builder()
            .content( this.content )
            .author( this.author )
            .password( this.password )
            .build();
    }
    public static BoardDto from( BoardEntity entity ){
        return BoardDto.builder()
                .id( entity.getId() )
                .author( entity.getAuthor() )
                .password( entity.getPassword() )
                .content( entity.getContent() )
                .createdAt( entity.getCreatedAt() )
                .updatedAt( entity.getUpdatedAt() )
                .build();
    }
}