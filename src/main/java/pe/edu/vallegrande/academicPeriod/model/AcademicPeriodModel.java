package pe.edu.vallegrande.academicPeriod.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Document(collection = "academic_period")
@Data
@AllArgsConstructor
public class AcademicPeriodModel {
    @Id
    private String idAcademicPeriod;
    private String academicPeriod;
    private String startDate;
    private String endDate;
    private String shift;
    private String cluster;
    private String status; // Active or Inactive

    public AcademicPeriodModel() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.startDate = LocalDate.now().format(formatter);
        this.endDate = LocalDate.now().format(formatter);
    }
}