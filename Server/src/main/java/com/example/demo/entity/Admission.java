package com.example.demo.entity;

/*
"id" SERIAL PRIMARY KEY,
"worker_id" INT REFERENCES "worker" ON DELETE SET NULL,
"academic_building_id" INT REFERENCES "academic_building" ON DELETE SET NULL,
"state_number" TEXT DEFAULT ' ' NOT NULL
*/
public class Admission extends BaseEntity{
    private Integer worker_id;
    private Integer academic_building_id;
    private String state_number;

    public Admission(Integer id, Integer worker_id, Integer academic_building_id, String state_number) {
        super(id);
        this.academic_building_id = academic_building_id;
        this.worker_id = worker_id;
        this.state_number = state_number;
    }

    public Integer getAcademic_building_id() {
        return academic_building_id;
    }

    public void setAcademic_building_id(Integer academic_building_id) {
        this.academic_building_id = academic_building_id;
    }

    public Integer getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(Integer worker_id) {
        this.worker_id = worker_id;
    }

    public String getState_number() {
        return state_number;
    }

    public void setState_number(String state_number) {
        this.state_number = state_number;
    }
}
