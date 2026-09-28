package vn.tuanlequoc.jobhunter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import vn.tuanlequoc.jobhunter.domain.Permission;
import vn.tuanlequoc.jobhunter.domain.Skill;

public interface PermissionRepository
        extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {
    boolean existsByModuleAndApiPathAndMethod(String module, String apiPath, String method);

    Page<Permission> findAll(Specification<Permission> spec, Pageable pageable);

    List<Permission> findByIdIn(List<Long> id);
}
