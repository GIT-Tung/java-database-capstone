package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorService {

    private List<Doctor> doctors;

    public DoctorService() {
        this.doctors = new ArrayList<>();
    }

    // 🕒 Lấy danh sách khung giờ còn trống trong ngày
    public List<LocalTime> getAvailableTimeSlots(String doctorId, LocalDate date) {
        List<LocalTime> available = new ArrayList<>();
        available.add(LocalTime.of(9, 0));
        available.add(LocalTime.of(10, 0));
        available.add(LocalTime.of(14, 0));
        available.add(LocalTime.of(15, 0));
        return available;
    }

    // 🔐 Kiểm tra thông tin đăng nhập bác sĩ
    public Map<String, String> validateDoctorLogin(String email, String password) {
        Map<String, String> response = new HashMap<>();
        for (Doctor d : doctors) {
            if (d.getEmail().equalsIgnoreCase(email) && d.getPassword().equals(password)) {
                response.put("status", "success");
                response.put("message", "Doctor login successful");
                return response;
            }
        }
        response.put("status", "error");
        response.put("message", "Invalid credentials");
        return response;
    }

    // ➕ Thêm bác sĩ (tuỳ chọn)
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
}
