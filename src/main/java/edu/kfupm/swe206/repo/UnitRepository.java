package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.Unit;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UnitRepository extends PagingAndSortingRepository<Unit, Long> {

  // List<Unit> findByBands(@Param("bands") List<JobBand> bands);

}
