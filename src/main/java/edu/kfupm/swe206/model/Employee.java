package edu.kfupm.swe206.model;

import java.util.*;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToOne private Candidate candidate;

  @OneToMany(mappedBy = "employee")
  private Set<Job> jobs;

  @OneToMany(mappedBy = "interviewer")
  private Set<Interview> interviews;

  protected Employee() {}

  public Employee(Candidate Candidate) {
    this.candidate = Candidate;
    this.candidate.setEmployee(this);
    this.jobs = new HashSet<>();
    this.interviews = new HashSet<>();
  }

  public void addJob(JobOffer jobOffer) {
    this.jobs.add(new Job(this, jobOffer));
  }

  public long getId() {
    return this.id;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public Set<Job> getJobs() {
    return jobs;
  }

  public void setJobs(Set<Job> jobs) {
    // Do all the jobs belong to this employee?
    boolean allBelong = jobs.stream().allMatch(e -> e.getEmployee().equals(this));
    if (allBelong) {
      this.jobs = jobs;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public Set<Interview> getInterviews() {
    return interviews;
  }

  public void setInterviews(Set<Interview> interviews) {
    // Do all the interviews belong to this employee?
    boolean allBelong = interviews.stream().allMatch(e -> e.getInterviewer().equals(this));
    if (allBelong) {
      this.interviews = interviews;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public boolean hasInterviewConflict(Date date) {

    for (Interview s : interviews) {
      if (s.date.equals(date)) return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", candidate=" + candidate + "]";
  }
}
