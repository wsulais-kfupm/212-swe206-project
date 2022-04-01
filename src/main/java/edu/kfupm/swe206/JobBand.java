package edu.kfupm.swe206;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class JobBand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "band")
    private Set<JobPosition> jobPositions;
    @ManyToMany(mappedBy = "bands")
    private Set<Unit> units;

    protected JobBand() {

    }

    public JobBand(String name, Set<JobPosition> jobPositions, Set<Unit> units) {
        this.name = name;
        this.jobPositions = jobPositions;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<JobPosition> getJobPositions() {
        return jobPositions;
    }

    public void setJobPositions(Set<JobPosition> jobPositions) {
        this.jobPositions = jobPositions;
    }

    public Set<Unit> getUnits() {
        return units;
    }

    public void setUnits(Set<Unit> units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "JobBand [id=" + id + ", name=" + name + "]";
    }

}
