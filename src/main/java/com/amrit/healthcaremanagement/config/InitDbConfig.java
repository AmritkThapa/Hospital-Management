package com.amrit.healthcaremanagement.config;


import com.amrit.healthcaremanagement.entity.Role;
import com.amrit.healthcaremanagement.entity.User;
import com.amrit.healthcaremanagement.repo.RoleRepo;
import com.amrit.healthcaremanagement.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class InitDbConfig {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;


    @PostConstruct
    public void doEntries(){
        if(roleRepo.findAll().size() == 0){
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            Role savedAdmin = roleRepo.save(adminRole);

            Role userRole = new Role();
            userRole.setName("USER");
            Role savedUser = roleRepo.save(userRole);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            User newAdmin  = new User();
            newAdmin.setFirst_name("Amrit");
            newAdmin.setLast_name("Thapa");
            newAdmin.setUsername("doctor");
            newAdmin.setEmail("doctor@gmail.com");
            newAdmin.setPassword(encoder.encode("doctor"));
            newAdmin.setRoles(Arrays.asList(savedAdmin));
            userRepo.save(newAdmin);

            User nonAdminUser = new User();
            nonAdminUser.setFirst_name("patient");
            nonAdminUser.setUsername("patient");
            nonAdminUser.setPassword(encoder.encode("patient"));
            nonAdminUser.setRoles(Arrays.asList(savedUser));
            userRepo.save(nonAdminUser);



        }
    }

}
