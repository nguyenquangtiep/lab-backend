package com.application.lab.mapper;

import com.application.lab.dto.StaffDto;
import com.application.lab.entity.Staff;

public class StaffMapper {

    public static StaffDto mapToStaffDto(Staff staff) {
        return new StaffDto(
                staff.getId(),
                staff.getFirstName(),
                staff.getLastName(),
                staff.getEmail()
        );
    }

    public static Staff mapToStaff(StaffDto staffDto) {
        return new Staff(
                staffDto.getId(),
                staffDto.getFirstName(),
                staffDto.getLastName(),
                staffDto.getEmail()
        );
    }
}
