package example.miniproject2.Dto;

import example.miniproject2.Entity.ReportEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Builder @Setter@Getter 
public class ReportDto {
    private Integer reportId;
    private String rNo;
    private String reportType;
    private String description;
    private String status;
    
    public ReportDto reportDto( ){
        return ReportDto.builder()
        .reportId(this.reportId)
        .rNo(this.rNo)
        .reportType(this.reportType)
        .description(this.description)
        .status(this.status)
        .build();
    }
    public static ReportDto from( ReportEntity reportEntity) {
        return  ReportDto.builder()
            .reportId(ReportDto.getReportId())
            .rNo(ReportDto.getRNo())
            .report_type(ReportDto.getReportId())
            .description(ReportDto.getDescription())
            .status(ReportDto.getStatus())
        .build()
    }
}
