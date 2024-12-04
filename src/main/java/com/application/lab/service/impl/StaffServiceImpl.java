package com.application.lab.service.impl;

import com.application.lab.dto.StaffDto;
import com.application.lab.entity.Staff;
import com.application.lab.exception.ResourceNotFoundException;
import com.application.lab.mapper.StaffMapper;
import com.application.lab.repository.StaffRepository;
import com.application.lab.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;

    @Override
    public StaffDto createStaff(StaffDto staffDto) {

        Staff staff = StaffMapper.mapToStaff(staffDto);
        Staff savedStaff = staffRepository.save(staff);

        return StaffMapper.mapToStaffDto(savedStaff);
    }

    @Override
    public StaffDto getStaffById(Long staffId) {
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ResourceNotFoundException("Staff is not exists with id: " + staffId));
        return StaffMapper.mapToStaffDto(staff);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream().map(StaffMapper::mapToStaffDto).collect(Collectors.toList());
    }

    @Override
    public StaffDto updateStaff(Long staffId, StaffDto staffDto) {
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException("Staff is not exists with id: " + staffId));

        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());
        staff.setEmail(staffDto.getEmail());

        Staff updatedStaff = staffRepository.save(staff);

        return StaffMapper.mapToStaffDto(updatedStaff);
    }

    @Override
    public void deleteStaff(Long staffId) {
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException("Staff is not exists with id: " + staffId));
        staffRepository.deleteById(staff.getId());
    }
}
