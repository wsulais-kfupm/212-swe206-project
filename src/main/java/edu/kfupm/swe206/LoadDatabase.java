package edu.kfupm.swe206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.kfupm.swe206.repo.*;
import edu.kfupm.swe206.model.*;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initEmployees(final CandidateRepository repo) {
        return args -> {
            repo.save(new Candidate("Wael", "Sulais", Gender.MALE));
            for (Candidate Candidate : repo.findAll()) {
                log.info("Preloaded " + Candidate);
            }
        };
    }

    @Bean
    CommandLineRunner initJobBands(final JobBandRepository bands, final JobPositionRepository pos) {
        return args -> {
            final JobBand engineering = new JobBand("Engineering");
            bands.save(engineering);

            for (JobBand band : bands.findAll()) {
                log.info("Preloaded " + band);
            }

            pos.save(new JobPosition("Lead Engineer", engineering,10000));
            pos.save(new JobPosition("Senior Engineer", engineering,14000));
            pos.save(new JobPosition("Engineer", engineering,8000));

            for (JobPosition p : pos.findAll()) {
                log.info("Preloaded " + p);
            }
        };
    }

    @Bean
    CommandLineRunner initUnits(final JobBandRepository bands, final UnitRepository units) {
        return args -> {
            JobBand engineering = bands.findById(2L);
            final Unit software = new Unit("Software", UnitType.Department);
            software.getBands().add(engineering);
            units.save(software);
            engineering.getUnits().add(software);
            for (Unit unit : units.findAll()) {
                log.info("Preloaded " + unit);
            }
        };
    }

    @Bean
    CommandLineRunner initJobs(final JobPositionRepository positions, final UnitRepository units,
            final JobRepository jobs, final CandidateRepository people) {
        return args -> {
            JobPosition position = positions.findById(5L).get();
            final Unit software = units.findById(6L).get();
            Candidate employee = people.findById(1L).get();
            Job job = new Job(software, employee, position, 10_000);
            jobs.save(job);
            for (Job j : jobs.findAll()) {
                log.info("Preloaded " + job);
            }
        };
    }
}
