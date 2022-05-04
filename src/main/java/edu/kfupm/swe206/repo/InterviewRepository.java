package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.Interview;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterviewRepository extends PagingAndSortingRepository<Interview, Long> {}
