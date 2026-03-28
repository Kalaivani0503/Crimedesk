package com.crime.crime_system.repository;

import com.crime.crime_system.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

    List<Complaint> findByCitizenId(Integer citizenId);
    List<Complaint> findByAssignedOfficerId(Integer assignedOfficerId);
    List<Complaint> findAll();
}