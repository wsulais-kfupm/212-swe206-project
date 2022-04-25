package edu.kfupm.swe206.model;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Enumerated;

public class Benefit{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String name;
    private double salaryRate;

    protected Benefit(){

    }
    public Benefit(String name,double salaryRate){
        this.name=name;
        this.salaryRate=salaryRate;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getSalaryRate(){
        return salaryRate;
    }
    public void setSalaryRate(double salaryRate){
        this.salaryRate=salaryRate;
    }




}