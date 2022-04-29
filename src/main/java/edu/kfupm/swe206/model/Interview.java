package edu.kfupm.swe206.model;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;

@Entity
public class Interview{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "interviewer_id")
    Employee interviewer;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    Candidate candidate;
    Date date;

    InterviewResult result;

    protected Interview(){

    }
    public Interview(Employee employee,Candidate candidate,Date date){
        this.interviewer=employee;
        this.candidate=candidate;
        this.date=date;

    }
    public Candidate getCandidate(){
        return candidate;
    }
    public void setCandidate(Candidate candidate){
        this.candidate=candidate;
    }
    public Employee getInterviewer(){
        return interviewer;
    }

    public void setInterviewer(Employee interviewer){

        this.interviewer= interviewer;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date data){
        this.date=date;
    }
    public InterviewResult getInterviewResult(){
        return result;
    }
    public void setInterviewResult(InterviewResult result){
        this.result=result;
    }


}
