package edu.kfupm.swe206.model;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.*;

import javax.persistence.*;

@Entity
public class Employee extends Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String forename;
    private String surname;
    private File CV;
    private String nationalId;
    @OneToMany(mappedBy = "employee")
    private Set<Interview> interviews;
    private Set<Job> jobs;
    @Enumerated(EnumType.STRING)
    Gender gender;
    EducationLevel educationLevel;

    int yearsOfExperince;


    protected Employee() {
    }

    public Employee(String forename, String surname, Set<Interview> interviews, Set<Job> jobs) {
        this.forename = forename;
        this.surname = surname;
        this.interviews = interviews;
        this.jobs = jobs;
    }
    public Employee(Candidate Candidate,JobOffer jobOffer) {
        this.forename = Candidate.getForename();
        this.surname = Candidate.getSurname();
        this.interviews = Candidate.getinterviews();
        this.nationalId = Candidate.getNationalId();
    }

    public void addJob(JobOffer jobOffer){
        this.jobs.add(new Job(this , jobOffer));
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
        return "Employee [id=" + id + ", forename=" + forename + ", surname=" + surname + ", national Id="+ nationalId +", years Of experince="+ yearsOfExperince+", number of Interviews="+ interviews.size() +"]";
    }


}
