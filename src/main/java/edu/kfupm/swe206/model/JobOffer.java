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
import java.util.stream.Stream;

public class JobOffer{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Unit unit;
    private JobPosition position;
    private double lowerSalary,higherSalary,offeredSalary;
    public Set<Benefit> benefits;
    private Candidate candidate;

    protected JobOffer(){
        
    }

    public JobOffer(Candidate candidate,Unit unit,JobPosition position,Set<Benefit> benefits){
        this.unit=unit;
        this.position=position;
        this.resetSalary(candidate,unit,position,benefits);
        this.candidate=candidate;
        this.benefits=benefits;
    }
    public void resetSalary(Candidate candidate,Unit unit,JobPosition position,Set<Benefit> benefits){
        int sumOfRates=0;
        double base_salary = position.getBaseSalary();
        base_salary += unit.getType().salaryBonus;
        for (Benefit s : benefits) {
            sumOfRates+=s.getSalaryRate();
        }
        lowerSalary = Math.max(base_salary,base_salary+500*(candidate.getYearsOfExperince()-2))*(1+sumOfRates);
        higherSalary = (base_salary+500*(candidate.getYearsOfExperince()+2))*(1+sumOfRates);
        offeredSalary=(higherSalary+lowerSalary)/2;
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


}
