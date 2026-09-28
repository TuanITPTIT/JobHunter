package vn.tuanlequoc.jobhunter.controller.client;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkraft.springfilter.boot.Filter;

import vn.tuanlequoc.jobhunter.domain.Job;
import vn.tuanlequoc.jobhunter.domain.reponse.ResultPaginationDTO;
import vn.tuanlequoc.jobhunter.service.JobService;
import vn.tuanlequoc.jobhunter.util.annotattion.ApiMessage;
import vn.tuanlequoc.jobhunter.util.error.IdInvalidException;

@RestController
@RequestMapping("/api/v1")
public class JobClientController {
    private final JobService jobService;

    public JobClientController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs/{id}")
    @ApiMessage("Fetch job by id")
    public ResponseEntity<Job> fetchJobById(@PathVariable("id") Long id) throws IdInvalidException {
        Job currentUser = this.jobService.fetchJobById(id);
        if (currentUser == null) {
            throw new IdInvalidException("Job với id = " + id + " không tồn tại");
        }
        return ResponseEntity.status(HttpStatus.OK).body(this.jobService.fetchJobById(id));

    }

    @GetMapping("/jobs")
    @ApiMessage("Fetch all jobs")
    public ResponseEntity<ResultPaginationDTO> getAllJob(@Filter Specification<Job> spec, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.jobService.fetchAllJobs(spec, pageable));
    }
}
