package edu.kfupm.swe206.repo;

import edu.kfupm.swe206.model.Candidate;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends PagingAndSortingRepository<Candidate, Long> {

  List<Candidate> findBySurname(@Param("name") String name);
}
