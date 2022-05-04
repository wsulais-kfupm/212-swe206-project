package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.JobPosition;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobPositionRepository extends PagingAndSortingRepository<JobPosition, Long> {}
