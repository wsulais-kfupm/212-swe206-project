package edu.kfupm.swe206;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "band_id")
    private JobBand band;
    @OneToMany(mappedBy = "position")
    private Set<Job> jobs;

    protected JobPosition() {
    }

    public JobPosition(String name, JobBand band, Set<Job> jobs) {
        this.name = name;
        this.band = band;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobBand getBand() {
        return band;
    }

    public void setBand(JobBand band) {
        this.band = band;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "JobPosition [id=" + id + ", name=" + name + "]";
    }

}
