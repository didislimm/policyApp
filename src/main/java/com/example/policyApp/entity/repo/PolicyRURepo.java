package com.example.policyApp.entity.repo;

import com.example.policyApp.entity.policyRU.RussianPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRURepo extends JpaRepository<RussianPolicy, Long> {
}
