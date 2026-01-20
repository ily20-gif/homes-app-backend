package com.example.backend.repository;

import com.example.backend.entity.HousingLocation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRepository extends JpaRepository<HousingLocation, Long> {
    @Modifying
    @Transactional
    @Query("""
   UPDATE HousingLocation h
   SET h.availableUnits = h.availableUnits - 1
   WHERE h.id = :id AND h.availableUnits > 0
""")
    int decrementAvailableUnits(@Param("id") Long id);
}
