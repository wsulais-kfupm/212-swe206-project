package edu.kfupm.swe206.controller;

import edu.kfupm.swe206.model.Candidate;
import edu.kfupm.swe206.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
public class CandidateController {
  @Autowired CandidateRepository candidates;

  @GetMapping(value = "/candidates/{id}/cv", produces = MediaType.APPLICATION_PDF_VALUE)
  Resource downloadCV(@PathVariable long id) {
    Candidate candidate =
        candidates
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    byte[] cv = candidate.getCV();
    if (cv == null || cv.length == 0) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } else {
      return new ByteArrayResource(candidate.getCV());
    }
  }

  @PostMapping(value = "/candidates/{id}/cv")
  void uploadCV(@PathVariable long id, @RequestParam MultipartFile file) throws Exception {
    Candidate candidate =
        candidates
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    if (file.getContentType().equals(MediaType.APPLICATION_PDF_VALUE)) {
      candidate.setCV(file.getBytes());
      candidates.save(candidate);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
}
