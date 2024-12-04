package com.application.lab.service;

import com.application.lab.dto.StaffDto;

import java.util.List;

public interface StaffService {
    StaffDto createStaff(StaffDto staffDto);

    StaffDto getStaffById(Long StaffId);

    List<StaffDto> getAllStaff();

    StaffDto updateStaff(Long staffId, StaffDto staffDto);

    void deleteStaff(Long staffId);
}
