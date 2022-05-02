package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.JobBand;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobBandRepository extends PagingAndSortingRepository<JobBand, Long> {
  @EntityGraph(value = "JobBandEager")
  JobBand findById(long id);
}
