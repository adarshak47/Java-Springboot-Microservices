package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PatientRequestDTO(
        @NotBlank(message = "Name is required") @Size(max = 100, message = "Name cannot exceed 100 characters") String name,
        @NotBlank(message = "Email is required") String email,
        @NotBlank(message = "Address is required") String address,
        @NotBlank(message = "Date of birth is required") String dateOfBirth,
        @NotBlank(message = "Registered date is required", groups = CreatePatientValidationGroup.class) String registeredDate) {
}
