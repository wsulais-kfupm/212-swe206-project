package edu.kfupm.swe206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initEmployees(PersonRepository repo) {
        return (args) -> {
            repo.save(new Person("Wael", "Sulais", new HashSet<Job>()));
            repo.findAll().forEach(person -> {
                log.info("Preloaded " + person);
            });
        };
    }

    @Bean
    CommandLineRunner initJobBands(JobBandRepository bands, JobPositionRepository pos) {
        return args -> {
            JobBand engineering = new JobBand("Engineering", new HashSet<JobPosition>(), new HashSet<Unit>());
            bands.save(engineering);

            bands.findAll().forEach(band -> {
                log.info("Preloaded " + band);
            });

            pos.save(new JobPosition("Lead Engineer", engineering, new HashSet<Job>()));
            pos.save(new JobPosition("Senior Engineer", engineering, new HashSet<Job>()));
            pos.save(new JobPosition("Engineer", engineering, new HashSet<Job>()));

            pos.findAll().forEach(p -> {
                log.info("Preloaded " + p);
            });
        };
    }
}
