package com.example.demo.controller;

import com.example.demo.entity.Worker;
import com.example.demo.repository.*;
import com.example.demo.resourse.ApplicationResource;
import com.example.demo.resourse.WorkerResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    private final ApplicationRepository applicationRepository;
    private final WorkerRepository workerRepository;

    public WorkerController(ApplicationRepository applicationRepository, WorkerRepository workerRepository) {
        this.applicationRepository = applicationRepository;
        this.workerRepository = workerRepository;
    }
    @CrossOrigin
    @GetMapping(value = "")
    WorkerResource[] getAll(@RequestParam(required = false) Object expand) {
        WorkerResource[] result = Arrays.stream(workerRepository.select())
                .map(entity -> {
                    WorkerResource resource = new WorkerResource(entity);
                    if (expand != null)
                        resource.setApplication(
                                Arrays.stream(applicationRepository.selectByWorkerIdQuery(entity.getId()))
                                        .map(e -> new ApplicationResource(e))
                                        .toArray(ApplicationResource[]::new)
                        );
                    System.out.println(entity.getSubdivision());
                    return resource;
                })
                .toArray(WorkerResource[]::new);
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    WorkerResource get(@PathVariable Integer id,
                          @RequestParam(required = false) Object expand) {
        Worker entity = workerRepository.select(id);
        if (entity == null) return null;
        WorkerResource resource = new WorkerResource(entity);
        if (expand != null)
            resource.setApplication(
                    Arrays.stream(applicationRepository.selectByWorkerIdQuery(entity.getId()))
                            .map(e -> new ApplicationResource(e))
                            .toArray(ApplicationResource[]::new)
            );
        return resource;
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    WorkerResource post(@RequestBody WorkerResource resource) {
        Worker entity = workerRepository.insert(resource.toEntity());
        if (entity == null) return null;
        return new WorkerResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    WorkerResource put(@PathVariable Integer id,
                          @RequestBody WorkerResource resource) {
        Worker entity = workerRepository.update(id, resource.toEntity());
        if (entity == null) return null;
        return new WorkerResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    WorkerResource delete(@PathVariable Integer id) {
        Worker entity = workerRepository.delete(id);
        if (entity == null) return null;
        return new WorkerResource(entity);
    }
}
