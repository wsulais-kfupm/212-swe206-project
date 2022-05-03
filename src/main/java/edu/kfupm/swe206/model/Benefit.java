package edu.kfupm.swe206.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Benefit {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false)
  String name;

  @Column(nullable = false)
  private double salaryRate;

  protected Benefit() {}

  public Benefit(String name, double salaryRate) {
    this.name = name;
    this.salaryRate = salaryRate;
  }

  public long getId() {
    return this.id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalaryRate() {
    return salaryRate;
  }

  public void setSalaryRate(double salaryRate) {
    this.salaryRate = salaryRate;
  }
}
