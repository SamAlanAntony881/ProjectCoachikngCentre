package com.example.practice.ProjectCoachingCentre.Coaches;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "coaches")
public class Coaches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String expertise;
    String classesTaken;
    String price;


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

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getClassesTaken() {
        return classesTaken;
    }

    public void setClassesTaken(String classesTaken) {
        this.classesTaken = classesTaken;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
