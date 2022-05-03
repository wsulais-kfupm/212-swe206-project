package edu.kfupm.swe206.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "unit_id")
  private Unit unit;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "job_position_id")
  private JobPosition position;

  private int salary;

  protected Job() {}

  public Job(Unit unit, Employee employee, JobPosition position, int salary) {
    this.unit = unit;
    this.employee = employee;
    this.position = position;
    this.salary = salary;
  }

  public Job(Employee employee, JobOffer offer) {
    this(offer.getUnit(), employee, offer.getPosition(), (int) offer.getOfferedSalary());
  }

  public long getId() {
    return this.id;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  public Employee getEmployee() {
    return employee;
  }

  public String getTitle() {
    return unit.getName() + " " + position.getName();
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public JobPosition getPosition() {
    return position;
  }

  public void setPosition(JobPosition position) {
    this.position = position;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Job [id="
        + id
        + ", employee="
        + employee
        + ", position="
        + position
        + ", salary="
        + salary
        + ", unit="
        + unit
        + "]";
  }
}
