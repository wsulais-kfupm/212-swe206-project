package edu.kfupm.swe206.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.kfupm.swe206.model.JobBand;

public interface JobBandRepository extends PagingAndSortingRepository<JobBand, Long> {
    @EntityGraph(value = "JobBandEager")
    JobBand findById(long id);
}
