package edu.kfupm.swe206;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private UnitType type;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Unit parent;
    @OneToMany(mappedBy = "parent")
    private Set<Unit> subunits;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "unit_job_bands", joinColumns = @JoinColumn(name = "unit_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "job_band_id", referencedColumnName = "id"))
    private Set<JobBand> bands;
    @OneToMany(mappedBy = "unit")
    private Set<Job> jobs;

    protected Unit() {

    }

    public Unit(String name, UnitType type, Unit parent, Set<Unit> subunits, Set<JobBand> bands, Set<Job> jobs) {
        this.name = name;
        this.type = type;
        this.parent = parent;
        this.subunits = subunits;
        this.bands = bands;
        this.jobs = jobs;
    }

    public Unit(String name, UnitType type, Set<JobBand> bands) {
        this(name, type, null, null, bands, null);
    }

    public Unit(String name, UnitType type) {
        this(name, type, new HashSet<JobBand>());
    }

    public String getTitle() {
        return getName() + " " + type;
    }

    public String getName() {
        return name;
    }

    public Unit getParent() {
        return parent;
    }

    public void setParent(Unit parent) {
        this.parent = parent;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitType getType() {
        return type;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

    public Set<Unit> getSubunits() {
        return subunits;
    }

    public void setSubunits(Set<Unit> subunits) {
        this.subunits = subunits;
    }

    public Set<JobBand> getBands() {
        return bands;
    }

    public void setBands(Set<JobBand> bands) {
        this.bands = bands;
    }

    @Override
    public String toString() {
        return "Unit [id=" + id + ", name=" + name + ", type=" + type + "]";
    }

}
