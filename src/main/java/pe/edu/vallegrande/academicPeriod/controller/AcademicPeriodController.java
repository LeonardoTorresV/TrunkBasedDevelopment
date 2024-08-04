package pe.edu.vallegrande.academicPeriod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.academicPeriod.model.AcademicPeriodModel;
import pe.edu.vallegrande.academicPeriod.repository.AcademicPeriodRepository;
import pe.edu.vallegrande.academicPeriod.service.AcademicPeriodService;
import pe.edu.vallegrande.academicPeriod.dto.AcademicPeriodDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/Academic_Period")
public class AcademicPeriodController {

    @Autowired
    private AcademicPeriodService service;
    private AcademicPeriodRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AcademicPeriodModel> createAcademicPeriod(@RequestBody AcademicPeriodDto academicPeriodModel){
        return service.addAcademic_period(academicPeriodModel);
    }

    @GetMapping
    public Flux<AcademicPeriodModel> getAcademicPeriods(){
        return service.findAllAcademicPeriods();
    }

    @GetMapping("/id/{id_academic_period}")
    public Mono<AcademicPeriodModel> getAcademicPeriodModel(@PathVariable String id_academic_period){
        return service.getAcademicPeriodById(id_academic_period);
    }

    @GetMapping("/{academic_period}")
    public Flux<AcademicPeriodModel> findAcademicPeriodModelUsingAcademicPeriod(@PathVariable String academic_period){
        return service.getAcademicPeriodByAcademicPeriod(academic_period);
    }

    @GetMapping("/cluster/{cluster}")
    public Flux<AcademicPeriodModel> findAcademicPeriodModelUsingCluster(@PathVariable String cluster){
        return service.getAcademicPeriodByCluster(cluster);
    }

    @GetMapping("/shift/{shift}")
    public Flux<AcademicPeriodModel> findAcademicPeriodModelUsingShift(@PathVariable String shift){
        return service.getAcademicPeriodByShift(shift);
    }

    @PutMapping("/{id}")
    public Mono<AcademicPeriodModel> updateAcademicPeriod(@PathVariable String id, @RequestBody AcademicPeriodDto academicPeriodDto) {
        return service.updateAcademicPeriod(id, academicPeriodDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAcademicPeriod(@PathVariable String id) {
        return service.deleteAcademicPeriod(id);
    }

    @PutMapping("/reactivate/{id}")
    public Mono<AcademicPeriodModel> reactivateAcademicPeriod(@PathVariable String id) {
        return service.reactivateAcademicPeriod(id);
    }

    @GetMapping("/active")
    public Flux<AcademicPeriodModel> getActiveAcademicPeriod() {
        return service.getActive();
    }

    @GetMapping("/inactive")
    public Flux<AcademicPeriodModel> getInactiveAcademicPeriod() {
        return service.getInactive();
    }


    @DeleteMapping("/physically/{id}")
    public Mono<String> deletePhysicallyAcademicPeriodModel(@PathVariable String id){
        return service.deletePhysicallyAcademicPeriodModel(id);
    }
}