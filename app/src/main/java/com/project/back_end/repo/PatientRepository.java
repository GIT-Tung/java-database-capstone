package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {

    private List<Patient> patients;

    public PatientRepository() {
        this.patients = new ArrayList<>();
    }

    // 🔍 Tìm bệnh nhân theo email
    public Patient findByEmail(String email) {
        for (Patient p : patients) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                return p;
            }
        }
        return null;
    }

    // 🔍 Tìm bệnh nhân theo email hoặc số điện thoại
    public Patient findByEmailOrPhone(String email, String phone) {
        for (Patient p : patients) {
            if (p.getEmail().equalsIgnoreCase(email) || p.getPhone().equals(phone)) {
                return p;
            }
        }
        return null;
    }

    // ➕ Thêm bệnh nhân (tùy chọn)
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}
