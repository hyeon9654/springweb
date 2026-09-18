package example.practice5.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter@NoArgsConstructor
@MappedSuperclass@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    // 최초 등록 시간
    @CreatedDate private LocalDateTime createdAt;

    // 마지막 수정 시간
    @LastModifiedDate private LocalDateTime updatedAt;
}