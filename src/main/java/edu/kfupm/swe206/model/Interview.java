package edu.kfupm.swe206.model;
import java.util.*;
public class Interview{
    Employee interviewer;
    Candidate Candidate;
    Date date;

    InterviewResult result;

    protected Interview(){

    }
    public Interview(Employee employee,Candidate Candidate,Date date){
        this.interviewer=employee;
        this.Candidate=Candidate;
        this.date=date;

    }
    public Candidate getCandidate(){
        return Candidate;
    }
    public void setCandidate(Candidate Candidate){
        this.Candidate=Candidate;
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
