package com.amrit.healthcaremanagement.repo;

import com.amrit.healthcaremanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from role where name=?1"
    )
    List<Role> getUserRole(String userRole);
}
