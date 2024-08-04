package pe.edu.vallegrande.academicPeriod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.academicPeriod.dto.AcademicPeriodDto;
import pe.edu.vallegrande.academicPeriod.repository.AcademicPeriodRepository;
import pe.edu.vallegrande.academicPeriod.model.AcademicPeriodModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AcademicPeriodService {

    @Autowired
    private AcademicPeriodRepository repository;

    // CREATE, READ, UPDATE AND DELETE

    public Mono<AcademicPeriodModel> addAcademic_period(AcademicPeriodDto academicPeriodDto){
        AcademicPeriodModel academicPeriodModel = new AcademicPeriodModel();
        academicPeriodModel.setAcademicPeriod(academicPeriodDto.getAcademicPeriod());
        academicPeriodModel.setStartDate(academicPeriodDto.getStartDate());
        academicPeriodModel.setEndDate(academicPeriodDto.getEndDate());
        academicPeriodModel.setShift(academicPeriodDto.getShift());
        academicPeriodModel.setCluster(academicPeriodDto.getCluster());
        academicPeriodModel.setStatus("A");
        return repository.save(academicPeriodModel);
    }

    public Flux<AcademicPeriodModel> findAllAcademicPeriods(){
        return repository.findAll();
    }

    public Mono<AcademicPeriodModel> getAcademicPeriodById(String idAcademicPeriod){
        return repository.findById(idAcademicPeriod);
    }

    public Flux<AcademicPeriodModel> getAcademicPeriodByAcademicPeriod(String academicPeriod){
        return repository.findByAcademicPeriod(academicPeriod);
    }

    public Flux<AcademicPeriodModel> getAcademicPeriodByShift(String shift){
        return repository.findByShift(shift);
    }

    public Flux<AcademicPeriodModel> getAcademicPeriodByCluster(String cluster){
        return repository.findByCluster(cluster);
    }

    public Mono<AcademicPeriodModel> updateAcademicPeriod(String id, AcademicPeriodDto academicPeriodModelRequest){
        return repository.findById(id).flatMap(AcademicPeriodModel -> {
            AcademicPeriodModel.setAcademicPeriod(academicPeriodModelRequest.getAcademicPeriod());
            AcademicPeriodModel.setStartDate(academicPeriodModelRequest.getStartDate());
            AcademicPeriodModel.setEndDate(academicPeriodModelRequest.getEndDate());
            AcademicPeriodModel.setShift(academicPeriodModelRequest.getShift());
            AcademicPeriodModel.setCluster(academicPeriodModelRequest.getCluster());
            return repository.save(AcademicPeriodModel);
        });

    }

    public Mono<Void> deleteAcademicPeriod(String id) {
        return repository.findById(id).flatMap(academicPeriod -> {
            academicPeriod.setStatus("I");
            return repository.save(academicPeriod).then(Mono.empty());
        });
    }

    public Mono<AcademicPeriodModel> reactivateAcademicPeriod(String id) {
        return repository.findById(id).flatMap(academicPeriod -> {
            if (academicPeriod != null && academicPeriod.getStatus().equals("I")) {
                academicPeriod.setStatus("A");
                return repository.save(academicPeriod);
            } else {
                return Mono
                        .error(new IllegalArgumentException("El formulario de contacto no está inactivo o no existe"));
            }
        });
    }

    public Flux<AcademicPeriodModel> getActive() {
        return repository.findByStatus("A");
    }

    public Flux<AcademicPeriodModel> getInactive() {
        return repository.findByStatus("I");
    }


    public Mono<String> deletePhysicallyAcademicPeriodModel(String id){
            return repository.deleteById(id)
                    .then(Mono.just(id + " Eliminado"));
    }
}
