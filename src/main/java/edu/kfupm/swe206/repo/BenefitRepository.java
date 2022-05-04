package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.Benefit;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BenefitRepository extends PagingAndSortingRepository<Benefit, Long> {}
