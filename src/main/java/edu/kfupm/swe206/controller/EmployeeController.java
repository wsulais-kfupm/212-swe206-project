package edu.kfupm.swe206.controller;

import edu.kfupm.swe206.model.Employee;
import edu.kfupm.swe206.model.Interview;
import edu.kfupm.swe206.repo.EmployeeRepository;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EmployeeController {
  @Autowired EmployeeRepository employees;

  public class ScheduledEvent {
    public OffsetDateTime start;
    public Duration duration;

    public ScheduledEvent(OffsetDateTime start, Duration duration) {
      this.start = start;
      this.duration = duration;
    }

    public OffsetDateTime getStart() {
      return this.start;
    }

    public Duration getDuration() {
      return this.duration;
    }
  }

  @GetMapping(value = "/employees/{id}/datesAvailable")
  List<ScheduledEvent> getDatesAvailable(
      @PathVariable long id,
      @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @RequestParam Optional<Duration> duration,
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Optional<LocalDate> date)
      throws Exception {
    Duration dur = duration.orElse(Interview.AVERAGE_DURATION);
    if (dur.isNegative() || dur.isZero()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    LocalDate day = date.orElse(LocalDate.now());
    Employee employee =
        employees.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    List<ScheduledEvent> times = new ArrayList<>();
    OffsetDateTime start = OffsetDateTime.of(day.atStartOfDay(), OffsetDateTime.now().getOffset());
    List<Interview> interviews =
        employee.getInterviews().stream()
            .filter(e -> e.getDate().toLocalDate().equals(day))
            .sorted((x, y) -> x.getDate().compareTo(y.getDate()))
            .collect(Collectors.toList());
    for (Interview interview : interviews) {
      Duration d = Duration.between(start, interview.getDate()).minus(dur);
      if (!d.isNegative() && !d.isZero()) {
        ScheduledEvent ev = new ScheduledEvent(start, d);
        times.add(ev);
      }
      start = interview.getDate();
      interview.getDuration().addTo(start);
    }
    Duration d = Duration.between(start.toLocalTime(), LocalTime.MAX).minus(dur);
    times.add(new ScheduledEvent(start, d));
    return times;
  }
}
