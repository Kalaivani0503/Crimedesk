package com.crime.crime_system.controller;

import com.crime.crime_system.entity.Complaint;
import com.crime.crime_system.entity.User;
import com.crime.crime_system.repository.ComplaintRepository;
import com.crime.crime_system.repository.UserRepository;
import com.crime.crime_system.dto.ComplaintRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ CREATE COMPLAINT
    @PostMapping
    public String createComplaint(@RequestBody ComplaintRequest req) {

        User user = userRepository.findByEmail(req.getEmail());

        if (user == null) {
            return "User not found";
        }

        Complaint c = new Complaint();
        c.setCitizenId(user.getId().intValue());
        c.setTitle(req.getTitle());
        c.setDescription(req.getDescription());
        c.setLocation(req.getLocation());
        c.setStatus("Pending");
        c.setDateFiled(LocalDateTime.now());

        complaintRepository.save(c);

        return "Complaint submitted";
    }

    // ✅ GET COMPLAINTS
    @GetMapping
    public List<Complaint> getComplaints(@RequestParam String email) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return List.of();
        }

        return complaintRepository.findByCitizenId(user.getId().intValue());
    }
    @GetMapping("/subinspectors")
    public List<User> getSubInspectors() {
        return userRepository.findByRole("sub_inspector");
    }

    @GetMapping("/all")
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }


    @PostMapping("/update")
    public String updateStatus(@RequestParam int complaintId, @RequestParam String status) {
        Complaint c = complaintRepository.findById(complaintId).orElse(null);
        if (c == null) return "Complaint not found";
        c.setStatus(status);
        complaintRepository.save(c);
        return "Updated";
    }
    @PostMapping("/assign")
    public String assignCase(
            @RequestParam Integer complaintId,
            @RequestParam Integer officerId) {

        Complaint complaint = complaintRepository.findById(complaintId).orElse(null);

        if (complaint == null) {
            return "Complaint not found";
        }

        complaint.setAssignedOfficerId(officerId);
        complaint.setStatus("Assigned");

        complaintRepository.save(complaint);

        return "Case Assigned Successfully";
    }
    @GetMapping("/assigned")
    public List<Complaint> getAssignedCases(@RequestParam Integer officerId) {
        return complaintRepository.findByAssignedOfficerId(officerId);
    }
}