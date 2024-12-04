package com.application.lab.controller;

import com.application.lab.dto.StaffDto;
import com.application.lab.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private StaffService staffService;

    // Build Add Staff REST API
    @PostMapping
    public ResponseEntity<StaffDto> createStaff(StaffDto staffDto) {
        StaffDto savedStaff = staffService.createStaff(staffDto);
        return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
    }

    // Build Get Staff REST API
    @GetMapping("{id}")
    public ResponseEntity<StaffDto> getStaffById(@PathVariable("id") Long staffId) {
        StaffDto staffDto = staffService.getStaffById(staffId);
        return new ResponseEntity<>(staffDto, HttpStatus.OK);
    }

    // Build Get All Staff REST API
    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaff() {
        List<StaffDto> staffDtoList = staffService.getAllStaff();
        return new ResponseEntity<>(staffDtoList, HttpStatus.OK);
    }

    // Build Update Staff REST API
    @PutMapping("{id}")
    public ResponseEntity<StaffDto> updateStaff(@PathVariable("id") Long staffId,
                                                @RequestBody StaffDto staffDto) {
        StaffDto updatedStaff = staffService.updateStaff(staffId, staffDto);
        return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
    }

    // Build Delete Staff REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") Long staffId) {
        staffService.deleteStaff(staffId);
        return new ResponseEntity<>("Staff deleted successfully!", HttpStatus.OK);
    }

}
