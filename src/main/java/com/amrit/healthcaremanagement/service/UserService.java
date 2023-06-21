package com.amrit.healthcaremanagement.service;

import com.amrit.healthcaremanagement.dto.request.UserRequestDto;
import com.amrit.healthcaremanagement.dto.response.UserResponseDto;

public interface UserService {

    UserResponseDto saveUserToTable(UserRequestDto userRequestDto);
}
