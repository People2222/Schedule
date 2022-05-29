package com.example.demo.resourse;

import com.example.demo.entity.Worker;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class WorkerResource implements Serializable {
    private Integer id;
    private String name;
    private String post;
    private String subdivision;
    private String phone_number;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AdmissionResource[] admission;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApplicationResource[] application;

    public WorkerResource(){}

    public WorkerResource(Worker worker){
        this.id = worker.getId();
        this.name = worker.getName();
        this.post = worker.getPost();
        this.subdivision = worker.getSubdivision();
        this.phone_number = worker.getPhone_number();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public AdmissionResource[] getAdmission() {
        return admission;
    }

    public void setAdmission(AdmissionResource[] admission) {
        this.admission = admission;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    public ApplicationResource[] getApplication() {
        return application;
    }
    public void setApplication(ApplicationResource[] application){
    this.application = application;}

    public Worker toEntity(){
        return new Worker(
                this.id,
                this.name,
                this.post,
                this.subdivision,
                this.phone_number);
    }
}
