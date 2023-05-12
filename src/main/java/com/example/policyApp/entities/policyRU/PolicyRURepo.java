package com.example.policyApp.entities.policyRU;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolicyRURepo extends JpaRepository <RussianPolicy, Long> {

    Optional<RussianPolicy> findByPolicyNumber(String policyNumber);
    Optional<RussianPolicy> findByRegistrationNumber(String registrationNumber);

}