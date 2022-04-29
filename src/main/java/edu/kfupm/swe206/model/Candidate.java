package edu.kfupm.swe206.model;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String forename;
    private String surname;
    @Column(nullable = false)
    private Gender gender;
    private File  cv;
    private String nationalId;
    @OneToMany(mappedBy = "candidate")
    private Set<Interview> interviews;
    @OneToMany(mappedBy = "candidate")
    private Set<JobOffer> jobOffers;
    private EducationLevel educationLevel;
    private int yearsOfExperience;

    @OneToOne
    private Employee employee;

    protected Candidate() {
    }

    public Candidate(String forename, String surname, Gender gender) {
        this.forename = forename;
        this.surname = surname;
        this.interviews = interviews;
        this.gender = gender;
        this.interviews = new HashSet<>();
        this.jobOffers = new HashSet<>();
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

    public void setForename(String forename) {
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

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Employee acceptOffer(JobOffer jobOffer){
        if (employee == null) {
            employee = new Employee(this);
        }
        employee.addJob(jobOffer);
        return employee;
    }

    public Set<Interview> getinterviews() {
        return interviews;
    }

    public void setinterviews(Set<Interview> interviews) {
        this.interviews = interviews;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender=gender;
    }
    public EducationLevel getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }
    public Employee getEmployee() {
        return employee;
    }
    void setEmployee(Employee employee) {
        if (employee.getCandidate().equals(this)) {
            this.employee = employee;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Candidate [id=" + id + ", forename=" + forename + ", surname=" + surname + "]";
    }

}
