package edu.kfupm.swe206.model;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Interview {

  public static final Duration AVERAGE_DURATION = Duration.ofHours(2).plusMinutes(30);

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "interviewer_id")
  Employee interviewer;

  @ManyToOne
  @JoinColumn(name = "candidate_id")
  Candidate candidate;

  @Column(nullable = false)
  OffsetDateTime date;

  @Column(nullable = false)
  Duration duration = AVERAGE_DURATION;

  InterviewResult result;

  protected Interview() {}

  public Interview(Employee employee, Candidate candidate, OffsetDateTime date) {
    this.interviewer = employee;
    this.candidate = candidate;
    this.date = date;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  public Employee getInterviewer() {
    return interviewer;
  }

  public void setInterviewer(Employee interviewer) {

    this.interviewer = interviewer;
  }

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public Duration getDuration() {
    return this.duration;
  }

  public void setDuration(Duration duration) {
    this.duration = duration;
  }

  public InterviewResult getResult() {
    return result;
  }

  public void setResult(InterviewResult result) {
    this.result = result;
  }
}
