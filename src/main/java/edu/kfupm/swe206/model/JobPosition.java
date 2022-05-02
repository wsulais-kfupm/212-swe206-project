package edu.kfupm.swe206.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
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

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "band_id")
  private JobBand band;

  @OneToMany(mappedBy = "position")
  private Set<Job> jobs;

  private double baseSalary;

  protected JobPosition() {}

  public JobPosition(String name, JobBand band, Set<Job> jobs, double baseSalary) {
    this.name = name;
    this.band = band;
    this.jobs = jobs;
    this.baseSalary = baseSalary;
  }

  public JobPosition(String name, JobBand band, double baseSalary) {
    this(name, band, new HashSet<Job>(), baseSalary);
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

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }

  @Override
  public String toString() {
    return "JobPosition [id=" + id + ", name=" + name + "]";
  }
}
