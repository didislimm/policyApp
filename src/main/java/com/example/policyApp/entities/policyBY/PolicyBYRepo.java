package com.example.policyApp.entities.policyBY;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolicyBYRepo extends  JpaRepository<BelarusPolicy,Long>{

    Optional<BelarusPolicy> findByPolicyNumber(String number);

    Optional<BelarusPolicy> findByRegistrationNumber(String registrationNumber);
}