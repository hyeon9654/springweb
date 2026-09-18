package example.practice3;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 자식클래스들이 호출할 수 있도록
@NoArgsConstructor
@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
public class BaseTime {
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime upDateTime;
}

// 로그( 모든 이벤트/행위 ) 관례적으로 남긴다.
