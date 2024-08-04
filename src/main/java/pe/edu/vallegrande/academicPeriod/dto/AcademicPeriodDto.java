package pe.edu.vallegrande.academicPeriod.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicPeriodDto {

    private String id;
    private String academicPeriod;
    private String startDate;
    private String endDate;
    private String shift;
    private String cluster;
    private String status; // Active or Inactive
}
