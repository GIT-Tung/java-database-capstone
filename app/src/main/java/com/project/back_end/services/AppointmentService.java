package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import com.project.back_end.models.Doctor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService {

    private List<Appointment> appointments;

    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    // 📅 Phương thức đặt lịch hẹn
    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // 📆 Lấy danh sách lịch hẹn theo bác sĩ và ngày
    public List<Appointment> getAppointmentsByDoctorAndDate(Doctor doctor, LocalDate date) {
        return appointments.stream()
                .filter(a -> a.getDoctor().equals(doctor) &&
                             a.getAppointmentTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    // 📋 Lấy tất cả lịch hẹn (tuỳ chọn)
    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}
