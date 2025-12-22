package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO patientToPatientResponseDTO(Patient patient) {
        if(patient == null) {
            return null;
        }
        return new PatientResponseDTO(patient.getId(), patient.getName(), patient.getEmail(), patient.getAddress(), patient.getDateOfBirth());
    }

    public static Patient patientRequestDTOToPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.name());
        patient.setEmail(patientRequestDTO.email());
        patient.setAddress(patientRequestDTO.address());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.dateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.registeredDate()));
        return patient;
    }
}
