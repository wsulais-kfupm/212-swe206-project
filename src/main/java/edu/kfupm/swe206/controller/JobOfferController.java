package edu.kfupm.swe206.controller;

import edu.kfupm.swe206.model.Job;
import edu.kfupm.swe206.model.JobOffer;
import edu.kfupm.swe206.model.Employee;
import edu.kfupm.swe206.repo.EmployeeRepository;
import edu.kfupm.swe206.repo.JobOfferRepository;
import edu.kfupm.swe206.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class JobOfferController {
  @Autowired JobOfferRepository offers;
  @Autowired JobRepository jobs;
  @Autowired EmployeeRepository employees;

  @PostMapping(value = "/jobOffers/{id}/accept")
  Long setResultAndMakeJobOffer(@PathVariable long id) throws Exception {
    JobOffer offer =
        offers.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Employee employee = offer.getCandidate().getEmployee();
    if (employee == null) {
        employee = new Employee(offer.getCandidate());
        employee = employees.save(employee);
    }
    Job job = jobs.save(new Job(employee, offer));
    offers.delete(offer);
    return job.getId();
  }
}
