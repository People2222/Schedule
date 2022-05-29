package com.example.demo.resourse;

import com.example.demo.entity.Admission;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class AdmissionResource implements Serializable {
    private Integer id;
    private Integer worker_id;
    private Integer academic_building_id;
    private String state_number;



    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AcademicBuildingResource academicBuilding;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private WorkerResource worker;

    public AdmissionResource(Admission admission) {
        this.id = admission.getId();
        this.worker_id = admission.getWorker_id();
        this.academic_building_id = admission.getAcademic_building_id();
        this.state_number = admission.getState_number();
    }

    public Integer getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(Integer worker_id) {
        this.worker_id = worker_id;
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

    public Admission toEntity(){
        return new Admission(
                this.id,
                this.worker_id,
                this.academic_building_id,
                this.state_number);
    }
}
