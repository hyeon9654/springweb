package example.practice4.dto;

import java.time.LocalDateTime;

import example.practice4.model.entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class EnrollDto {
    private Intger enrollId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime upDatedAt;
    // 자바(JPA)에서 entity로 FK 사용하지만 입력받을 경우 FK번호 받는다.
    private Integer courseId;
    private Integer studentId;
    // + 과정명, 학생명
    private String courseName;
    private String studentName;
    // + toEntity
    public EnrollEntity toEntity( ){
        return  EnrollEntity.builder()
                .status(this.status)
                // 학생FK, 과정FK은 서비스에서 엔티티로 변환~~
                .build()
    }
    // + from
    public static EnrollDto from( EnrollEntity entity ){
        return EnrollDto.builder()
                .enrollId( entity,getEnrollId() )
                .status( entity.getStatus() )
                .build()
    }
}
