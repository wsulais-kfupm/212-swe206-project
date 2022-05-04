package edu.kfupm.swe206.model;

public enum UnitType {
  Division(1000),
  Directorate(500),
  Department(0);

  public double salaryBonus;

  UnitType(double salaryBonus) {
    this.salaryBonus = salaryBonus;
  }
}
