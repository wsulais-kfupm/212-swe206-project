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




}