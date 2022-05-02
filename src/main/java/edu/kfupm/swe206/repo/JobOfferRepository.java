package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.JobOffer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobOfferRepository extends PagingAndSortingRepository<JobOffer, Long> {}
