package example.miniproject2.Entity;

import example.miniproject2.BaseTime;
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
import lombok.ToString;

@Entity
@Table( name = "report" )
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter @ToString 
public class ReportEntity extends BaseTime{
    // 1. 신고번호 PK
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "report_id" )
    private Integer reportId;
    // 2. 대여번호 FK
    @ManyToOne
    @JoinColumn( name = "r_no")
    @ToString.Exclude
    private RentalEntity rental;
    // 3. 신고유형
    @Column( name = "report_type", length = 20, nullable = false )
    private String reportType;
    // 4. 신고내용
    @Column ( name = "description", columnDefinition = "TEXT", nullable = false )
    private String description;
    // 5. 신고상태
    @Column (name = "status", length = 20)
    private String status;

}
