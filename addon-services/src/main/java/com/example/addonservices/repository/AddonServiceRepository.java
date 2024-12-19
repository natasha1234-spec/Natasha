package com.example.addonservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.addonservices.model.AddonService;

public interface AddonServiceRepository extends JpaRepository<AddonService, Long> {
}
