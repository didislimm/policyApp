package com.example.policyApp.entity.repo;

import com.example.policyApp.entity.policyBY.BelarusPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyBYRepo extends JpaRepository<BelarusPolicy, Long> {
}
