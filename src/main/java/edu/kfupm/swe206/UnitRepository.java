package edu.kfupm.swe206;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UnitRepository extends PagingAndSortingRepository<Unit, Long> {

    // List<Unit> findByBands(@Param("bands") List<JobBand> bands);

}
