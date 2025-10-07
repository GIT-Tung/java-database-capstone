package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {
    private List<Doctor> doctors;

    public DoctorController() {
        this.doctors = new ArrayList<>();
    }

    // Thêm bác sĩ mới
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Lấy danh sách tất cả bác sĩ
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Tìm bác sĩ theo ID
    public Doctor getDoctorById(String doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(doctorId)) {
                return doctor;
            }
        }
        return null;
    }

    // Xóa bác sĩ theo ID
    public boolean removeDoctor(String doctorId) {
        return doctors.removeIf(d -> d.getDoctorId().equals(doctorId));
    }
}
