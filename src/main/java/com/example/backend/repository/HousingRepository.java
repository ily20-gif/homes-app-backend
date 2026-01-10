package com.example.backend.repository;

import com.example.backend.entity.HousingLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRepository extends JpaRepository<HousingLocation, Long> {}
