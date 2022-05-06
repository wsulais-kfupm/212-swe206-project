package edu.kfupm.swe206.controller;

import edu.kfupm.swe206.model.Interview;
import edu.kfupm.swe206.model.InterviewResult;
import edu.kfupm.swe206.model.JobOffer;
import edu.kfupm.swe206.repo.InterviewRepository;
import edu.kfupm.swe206.repo.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class InterviewController {
  @Autowired InterviewRepository interviews;
  @Autowired JobOfferRepository jobOffers;

  @PostMapping(value = "/interviews/{id}/result")
  Long setResultAndMakeJobOffer(@PathVariable long id, @RequestParam InterviewResult result)
      throws Exception {
    Interview interview =
        interviews
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    if (interview.getResult() == null) {
      interview.setResult(result);
      interviews.save(interview);
      if (result == InterviewResult.PASS) {
        JobOffer offer = jobOffers.save(JobOffer.fromInterview(interview));
        return offer.getId();
      } else {
        // No job offer was created so we pass in a sentinel value
        return -1L;
      }
    } else {
      throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }
  }
}
