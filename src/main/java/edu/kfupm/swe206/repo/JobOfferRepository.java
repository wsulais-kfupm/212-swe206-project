package edu.kfupm.swe206.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.kfupm.swe206.model.JobOffer;

public interface JobOfferRepository extends PagingAndSortingRepository<JobOffer, Long> {
}
