package com.nexsystech.interview.helper.repository;

import com.nexsystech.interview.helper.entity.ERole;
import com.nexsystech.interview.helper.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
