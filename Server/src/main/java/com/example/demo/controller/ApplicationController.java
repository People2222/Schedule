package com.example.demo.controller;

import com.example.demo.entity.Application;
import com.example.demo.repository.*;
import com.example.demo.resourse.AcademicBuildingResource;
import com.example.demo.resourse.ApplicationResource;
import com.example.demo.resourse.WorkerResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/application")
public class ApplicationController {
    private final AcademicBuildingRepository academicBuildingRepository;
    private final WorkerRepository workerRepository;
    private final ApplicationRepository applicationRepository;

    public ApplicationController(AcademicBuildingRepository academicBuildingRepository,  WorkerRepository workerRepository, ApplicationRepository applicationRepository) {
        this.academicBuildingRepository = academicBuildingRepository;
        this.workerRepository = workerRepository;
        this.applicationRepository = applicationRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    ApplicationResource[] getAll(@RequestParam(required = false) Integer academic_building_id,
                                 @RequestParam(required = false) Integer worker_id ,
                                 @RequestParam(required = false) Object expand) {

        Application[]entities;
        if (!(academic_building_id == null) && (worker_id == null)){
            entities = applicationRepository.selectByAcademicBuildingIdQuery(academic_building_id);
        }
        else if ((academic_building_id == null) && !(worker_id == null)){
            entities = applicationRepository.selectByWorkerIdQuery(worker_id);
        }
        else {
            entities = applicationRepository.select();
        }

        return Arrays.stream(entities)
                .map(entity -> {
                    ApplicationResource resource = new ApplicationResource(entity);
                    if (expand != null) {
                        resource.setWorker(new WorkerResource(
                                workerRepository.select(entity.getWorker_id())));
                        resource.setAcademicBuilding(new AcademicBuildingResource(
                                academicBuildingRepository.select(entity.getAcademic_building_id())));
                    }
                    return resource;
                })
                .toArray(ApplicationResource[]::new);
    }
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ApplicationResource get(@PathVariable Integer id,
                          @RequestParam(required = false) Object expand) {
        Application entity = applicationRepository.select(id);
        if (entity == null) return null;
        ApplicationResource resource = new ApplicationResource(entity);
        /*if (expand != null)
            resource.setWorker(new WorkerResource(
                    workerRepository.select(entity.getWorker_id()))
            );*/
        return resource;
    }
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    ApplicationResource post(@RequestBody ApplicationResource resource) {
        Application entity = applicationRepository.insert(resource.toEntity());
        if (entity == null) return null;
        resource = new ApplicationResource(entity);
        return resource;
    }
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ApplicationResource put(@PathVariable Integer id,
                          @RequestBody ApplicationResource resource) {
        Application entity = applicationRepository.update(id, resource.toEntity());
        if (entity == null) return null;
        resource = new ApplicationResource(entity);
        return resource;
    }
    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ApplicationResource delete(@PathVariable Integer id) {
        Application entity = applicationRepository.delete(id);
        if (entity == null) return null;
        ApplicationResource resource = new ApplicationResource(entity);
        return resource;
    }
}
