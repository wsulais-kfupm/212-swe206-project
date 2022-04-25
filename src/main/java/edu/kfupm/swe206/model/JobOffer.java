package edu.kfupm.swe206.model;


import jdk.internal.net.http.common.Pair;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import java.util.Set;

public class JobOffer{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Unit unit;
    private JobPosition position;
    private double lowerSalary,higherSalary,offeredSalary;
    public Set<Benefit> benefits;

    protected JobOffer(){
        
    }

    public JobOffer(Unit unit,JobPosition position,double lowerSalary,double higherSalary,double offeredSalary, Set<Benefit> benefits){
        this.unit=unit;
        this.position=position;
        this.lowerSalary=lowerSalary;
        this.higherSalary=higherSalary;
        this.offeredSalary=offeredSalary;
        this.benefits=benefits;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public JobPosition getPosition() {
        return position;
    }

    public void setPosition(JobPosition position) {
        this.position = position;
    }

    public double getLowerSalary() {
        return lowerSalary;
    }

    public void setLowerSalary(double lowerSalary) {
        this.lowerSalary = lowerSalary;
    }

    public double getHigherSalary() {
        return higherSalary;
    }

    public void setHigherSalary(double higherSalary) {
        this.higherSalary = higherSalary;
    }

    public double getOfferedSalary() {
        return offeredSalary;
    }

    public void setOfferedSalary(double offeredSalary) {
        this.offeredSalary = offeredSalary;
    }

    public Set<Benefit> getBenefits() {
        return benefits;
    }

    public void setBenefits(Set<Benefit> benefits) {
        this.benefits = benefits;
    }

    public Pair<Double, Double> getSalaryRange(){
        return new Pair<Double, Double>(lowerSalary,higherSalary);
    }
}