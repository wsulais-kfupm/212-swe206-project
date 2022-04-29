package edu.kfupm.swe206.model;




import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import java.util.Set;
import java.util.stream.Stream;

@Entity
public class JobOffer{

    /** Years of Experience Bonus Rate
     *  */
    public static final double YOE_RATE = 500.;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable=false)
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "job_position_id", nullable=false)
    private JobPosition position;
    private double offeredSalary;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "job_offer_benefits", joinColumns = @JoinColumn(name = "job_offer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "benefit_id", referencedColumnName = "id"))
    public Set<Benefit> benefits;
    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable=false)
    private Candidate candidate;

    protected JobOffer(){
        
    }

    public JobOffer(Candidate candidate,Unit unit,JobPosition position,Set<Benefit> benefits){
        this.unit=unit;
        this.position=position;
        this.candidate=candidate;
        this.benefits=benefits;
        this.offeredSalary = getBaseSalary()*getBenefitRates();
    }

    Candidate getCandidate() {
        return candidate;
    }

    void setCandidate(Candidate candidate) {
        this.candidate = candidate;
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

    public double getBaseSalary() {
        return position.getBaseSalary() + unit.getType().salaryBonus;
    }

    public double getBenefitRates() {
        return 1+benefits.stream().mapToDouble(e -> e.getSalaryRate()).sum();
    }

    private double getSalary(int years) {
        return (getBaseSalary()+YOE_RATE*years)*getBenefitRates();
    }

    public double getLowerSalary() {
        return getSalary(Math.max(0, candidate.getYearsOfExperience()-2));
    }

    public double getHigherSalary() {
        return getSalary(candidate.getYearsOfExperience()+2);
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
