package com.example.demo.entity;

import java.sql.Timestamp;

/*
*                         "id" SERIAL PRIMARY KEY,
                        "brand_of_transport" TEXT DEFAULT ' ' NOT NULL,
                        "model" TEXT DEFAULT ' ' NOT NULL,
                        "state_number" TEXT DEFAULT ' ' NOT NULL,
                        "color" TEXT DEFAULT ' ' NOT NULL,
                        "owner" TEXT DEFAULT ' ' NOT NULL,
                        "worker_id" INT REFERENCES "worker" ON DELETE SET NULL,
                        "academic_building_id" INT REFERENCES "academic_building" ON DELETE SET NULL,
                        "temp" TIMESTAMP,
                        "status" TEXT DEFAULT ' ' NOT NULL

* */
public class Application extends BaseEntity{
    private String brand_of_transport;
    private String model;
    private String state_number;
    private String color;
    private String owner;
    private Integer worker_id;
    private Integer academic_building_id;
    private Timestamp temp;
    private String status;


    public Application(Integer id,
                       String brand_of_transport,
                                String model,
                                String state_number,
                                String color,
                                String owner,
                                Integer worker_id,
                                Integer academic_building_id,
                                Timestamp temp,
                                String status
                       ) {
        super(id);
        this.brand_of_transport = brand_of_transport;
        this.model = model;
        this.state_number = state_number;
        this.color = color;
        this.owner = owner;
        this.worker_id = worker_id;
        this.academic_building_id = academic_building_id;
        this.temp = temp;
        this.status = status;
    }

    public void setBrand_of_transport(String brand_of_transport) {
        this.brand_of_transport = brand_of_transport;
    }

    public String getBrand_of_transport() {
        return brand_of_transport;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}
