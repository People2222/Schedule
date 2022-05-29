package com.example.demo.controller;

import com.example.demo.entity.Admission;
import com.example.demo.repository.AcademicBuildingRepository;
import com.example.demo.repository.AdmissionRepository;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.resourse.AcademicBuildingResource;
import com.example.demo.resourse.AdmissionResource;
import com.example.demo.resourse.WorkerResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/admission")
public class AdmissionController {
    private final AdmissionRepository admissionRepository;
    private final AcademicBuildingRepository academicBuildingRepository;
    private final WorkerRepository workerRepository;

    public AdmissionController(AdmissionRepository admissionRepository, AcademicBuildingRepository academicBuildingRepository, WorkerRepository workerRepository) {
        this.admissionRepository = admissionRepository;
        this.academicBuildingRepository = academicBuildingRepository;
        this.workerRepository = workerRepository;
    }
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    AdmissionResource[] getAll(@RequestParam(required = false) Integer academic_building_id,
                               @RequestParam(required = false) Integer worker_id ,
                               @RequestParam(required = false) Object expand) {

            Admission[]entities;
            if (!(academic_building_id == null) && (worker_id == null)){
                entities = admissionRepository.selectByAcademicBuildingIdQuery(academic_building_id);
            }
            else if ((academic_building_id == null) && !(worker_id == null)){
                entities = admissionRepository.selectByWorkerIdQuery(worker_id);
            }
            else {
                entities = admissionRepository.select();
            }

        return Arrays.stream(entities)
                .map(entity -> {
                    AdmissionResource resource = new AdmissionResource(entity);
                    if (expand != null) {
                        resource.setWorker(new WorkerResource(
                                workerRepository.select(entity.getWorker_id())));
                        resource.setAcademicBuilding(new AcademicBuildingResource(
                                academicBuildingRepository.select(entity.getAcademic_building_id())));
                    }
                    return resource;
                })
                .toArray(AdmissionResource[]::new);
    }
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    AdmissionResource get(@PathVariable Integer id,
                        @RequestParam(required = false) Object expand) {
        Admission entity = admissionRepository.select(id);
        if (entity == null) return null;
        AdmissionResource resource = new AdmissionResource(entity);
        /*if (expand != null)
            resource.setWorker(new WorkerResource(
                    workerRepository.select(entity.getWorker_id()))
            );*/
        return resource;
    }
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    AdmissionResource post(@RequestBody AdmissionResource resource) {
        Admission entity = admissionRepository.insert(resource.toEntity());
        if (entity == null) return null;
        resource = new AdmissionResource(entity);
        return resource;
    }
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    AdmissionResource put(@PathVariable Integer id,
                        @RequestBody AdmissionResource resource) {
        Admission entity = admissionRepository.update(id, resource.toEntity());
        if (entity == null) return null;
        resource = new AdmissionResource(entity);
        return resource;
    }
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    AdmissionResource delete(@PathVariable Integer id) {
        Admission entity = admissionRepository.delete(id);
        if (entity == null) return null;
        AdmissionResource resource = new AdmissionResource(entity);
        return resource;
    }
}
