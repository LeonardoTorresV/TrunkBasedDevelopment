package pe.edu.vallegrande.academicPeriod.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import pe.edu.vallegrande.academicPeriod.model.AcademicPeriodModel;
import reactor.core.publisher.Flux;

@EnableReactiveMongoRepositories
public interface AcademicPeriodRepository extends ReactiveMongoRepository<AcademicPeriodModel, String> {
    Flux<AcademicPeriodModel> findByAcademicPeriod(String academicPeriod);
    Flux<AcademicPeriodModel> findByShift(String shift);
    Flux<AcademicPeriodModel> findByCluster(String cluster);
    Flux<AcademicPeriodModel> findByStatus(String status);
}
