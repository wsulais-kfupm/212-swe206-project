package edu.kfupm.swe206.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Enumerated;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String forename;
    private String surname;
    private File  CV;
    private String nationalId;
    @OneToMany(mappedBy = "employee")
    private Set<Interview> interviews;
    @Enumerated(EnumType.STRING)
    Gender gender;
    EducationLevel educationLevel;

    int yearsOfExperince;


    protected Candidate() {
    }

    public Candidate(String forename, String surname, Set<interview> interviews) {
        this.forename = forename;
        this.surname = surname;
        this.interviews = interviews;
    }

    public Set<interview> getinterviews() {
        return interviews;
    }

    public void setinterviews(Set<interview> interviews) {
        this.interviews = interviews;
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
        return CV;
    }
    public void setCV(File CV) {
        this.CV=CV;
    }

    public Employee acceptOffer(JobOffer jobOffer){
        return Employee(this,jobOffer);
         }
    public String getGender() {
        return gender;
    }
    public void setNationalId(String nationalId) {
        this.nationalId=nationalId;
    }

    @Override
    public String toString() {
        return "Candidate [id=" + id + ", forename=" + forename + ", surname=" + surname + ", national Id="+ nationalId +", years Of experince="+ yearsOfExperince+", number of Interviews="+ interviews.size() +"]";
    }


}
