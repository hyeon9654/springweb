package example.SpringTotal.model.dto;

import java.util.ArrayList;
import java.util.List;

import example.SpringTotal.model.entity.CategoryEntity;
import example.SpringTotal.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
@ToString @Builder 
public class CategoryDto {
    private Integer cno;
    private String name;
    
    // private LocalDateTime createAt;
    // private LocalDateTime updateAt;

    // 제품 목록
    @Builder.Default
    private List<ProductEntity> products = new ArrayList<>();

    public CategoryEntity dtoToEntity(){
        return CategoryEntity.builder()
                            .cno(this.cno)
                            .name(this.name)
                            .build();
    }

    public static CategoryDto entityToDto(CategoryEntity categoryEntity){
        return CategoryDto.builder()
                            .cno(categoryEntity.getCno())
                            .name(categoryEntity.getName())
                            // .createAt(categoryEntity.getCreateAt())
                            // .updateAt(categoryEntity.getUpdateAt())
                            .build();
    }
}