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
    public Employee getInterviewer(){
        return interviewer;
    }
    public Date getDate(){
        return date;
    }
    public InterviewResult getInterviewResult(){
        return result;
    }
    

}