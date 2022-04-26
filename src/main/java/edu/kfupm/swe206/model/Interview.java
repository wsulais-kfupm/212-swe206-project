package edu.kfupm.swe206.model;
import java.util.*;
public class Interview{
    Employee interviewer;
    Person person;
    Date date;

    InterviewResult result;

    protected Interview(){

    }
    public Interview(Employee employee,Person person,Date date){
        this.interviewer=employee;
        this.person=person;
        this.date=date;

    }
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person){
        this.person=person;
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
