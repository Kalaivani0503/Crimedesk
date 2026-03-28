package com.crime.crime_system.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private Integer complaintId;

    @Column(name = "citizen_id")
    private Integer citizenId;

    private String title;
    private String description;
    private String location;

    @Column(name = "assigned_officer_id")
    private Integer assignedOfficerId;

    @Column(name = "date_filed")
    private LocalDateTime dateFiled;

    private String status;

    // Getters & Setters

    public Integer getComplaintId() { return complaintId; }
    public void setComplaintId(Integer complaintId) { this.complaintId = complaintId; }

    public Integer getCitizenId() { return citizenId; }
    public void setCitizenId(Integer citizenId) { this.citizenId = citizenId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getDateFiled() { return dateFiled; }
    public void setDateFiled(LocalDateTime dateFiled) { this.dateFiled = dateFiled; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getAssignedOfficerId() { return assignedOfficerId; }
    public void setAssignedOfficerId(Integer assignedOfficerId) { this.assignedOfficerId = assignedOfficerId; }
}