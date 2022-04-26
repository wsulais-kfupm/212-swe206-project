package edu.kfupm.swe206.model;

import java.util.List;
import java.util.Set;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String forename;
    private String surname;
    @Column(nullable = false)
    private Gender gender;
    @OneToMany(mappedBy = "employee")
    private Set<Job> jobs;

    private File  cv;
    private String nationalId;
    @OneToMany(mappedBy = "employee")
    private Set<Interview> interviews;
    private EducationLevel educationLevel;
    private int yearsOfExperince;

    protected Person() {
    }

    public Person(String forename, String surname, Set<Job> jobs) {
        this.forename = forename;
        this.surname = surname;
        this.jobs = jobs;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public String getName() {
        return forename + " " + surname;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.forename = parts[0];
        this.surname = parts[1];
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String firstName) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationalId() {
        return nationalId;
    }
    public void setNationalId(String nationalId) {
        this.nationalId=nationalId;
    }
    public File getCV() {
        return cv;
    }
    public void setCV(File CV) {
        this.cv=cv;
    }

    public Employee acceptOffer(JobOffer jobOffer){
        return new Employee(this, jobOffer);
    }

    public Set<Interview> getinterviews() {
        return interviews;
    }

    public void setinterviews(Set<Interview> interviews) {
        this.interviews = interviews;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", forename=" + forename + ", surname=" + surname + "]";
    }

}
