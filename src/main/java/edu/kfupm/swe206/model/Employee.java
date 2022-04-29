package edu.kfupm.swe206.model;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.*;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Candidate candidate;
    @OneToMany(mappedBy = "employee")
    private Set<Job> jobs;
    @OneToMany(mappedBy = "interviewer")
    private Set<Interview> interviews;

    protected Employee() {
    }

    public Employee(Candidate Candidate,JobOffer jobOffer) {
        this.candidate = Candidate;
        this.jobs = new HashSet<>();
        this.interviews = new HashSet<>();
        addJob(jobOffer);
    }

    public void addJob(JobOffer jobOffer){
        this.jobs.add(new Job(this.candidate, jobOffer));
    }

    public boolean hasInterviewConflict(Date date){

        for (Interview s : interviews) {
            if(s.date.equals(date))
                return true;
        }
        return false;



    }

    @Override
    public String toString() {
        return "Employee [candidate=" + candidate + "]";
    }


}
