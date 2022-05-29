package com.example.demo.resourse;

import com.example.demo.entity.Application;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApplicationResource implements Serializable {
    private Integer id;
    private String brand_of_transport;
    private String model;
    private String state_number;
    private String color;
    private String owner;
    private Integer worker_id;
    private Integer academic_building_id;
    private Timestamp temp;
    private String status;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AcademicBuildingResource academicBuilding;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private WorkerResource worker;

    public ApplicationResource(){}

    public String getBrand_of_transport() {
        return brand_of_transport;
    }

    public void setBrand_of_transport(String brand_of_transport) {
        this.brand_of_transport = brand_of_transport;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(Integer worker_id) {
        this.worker_id = worker_id;
    }

    public Timestamp getTemp() {
        return temp;
    }

    public void setTemp(Timestamp temp) {
        this.temp = temp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ApplicationResource(Application application) {
        this.id = application.getId();
        this.brand_of_transport = application.getBrand_of_transport();
        this.model = application.getModel();
        this.state_number = application.getState_number();
        this.color = application.getColor();
        this.owner = application.getOwner();
        this.worker_id = application.getWorker_id();
        this.academic_building_id = application.getAcademic_building_id();
        this.temp = application.getTemp();
        this.status = application.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAcademic_building_id() {
        return academic_building_id;
    }

    public void setAcademic_building_id(Integer academic_building_id) {
        this.academic_building_id = academic_building_id;
    }

    public String getState_number() {
        return state_number;
    }

    public void setState_number(String state_number) {
        this.state_number = state_number;
    }

    public AcademicBuildingResource getAcademicBuilding() {
        return academicBuilding;
    }

    public void setAcademicBuilding(AcademicBuildingResource academicBuilding) {
        this.academicBuilding = academicBuilding;
    }

    public WorkerResource getWorker() {
        return worker;
    }

    public void setWorker(WorkerResource worker) {
        this.worker = worker;
    }

    public Application toEntity(){
        return new Application(
                this.id,
                this.brand_of_transport,
        this.model,
        this.state_number,
        this.color ,
        this.owner ,
        this.worker_id ,
        this.academic_building_id,
        this.temp,
        this.status);
    }
}

