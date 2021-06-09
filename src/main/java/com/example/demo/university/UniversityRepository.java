package com.example.demo.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {

    @Query("SELECT s FROM University s WHERE s.name = ?1")
    Optional<University> findUniversityByName(String name);
}
