package edu.kfupm.swe206.model;

public class Interview{
    Employee interviewer;
    Candidate candidate;
    .class date;
    
    @Enumerated(EnumType.STRING)
    InterviewResult result;

    protected Interview(){

    }
    public Interview(Employee employee,Candidate candidate,Date date){
        this.interviewer=employee;
        this.candidate=candidate;
        this.data=data;

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
    public Employee setInterviewer(Employee interviewer){
        this.employee= interviewer;
    }
    public .class getDate(){
        return date;
    }
    public void setDate(.class data){
        this.data=date;
    }
    public InterviewResult getInterviewResult(){
        return result;
    }
    public void setInterviewResult(InterviewResult result){
        this.result=result;
    }
    

}