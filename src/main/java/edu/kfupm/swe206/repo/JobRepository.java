package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.Job;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {}
