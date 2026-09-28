package vn.tuanlequoc.jobhunter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import vn.tuanlequoc.jobhunter.domain.Resume;
import vn.tuanlequoc.jobhunter.util.constant.StatusEnum;

public interface ResumeRepository extends JpaRepository<Resume, Long>, JpaSpecificationExecutor<Resume> {
    Page<Resume> findAll(Specification<Resume> spec, Pageable pageable);

    long countByStatus(StatusEnum status);
}
