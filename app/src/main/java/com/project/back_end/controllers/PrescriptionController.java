package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionController {

    private List<Prescription> prescriptions;

    public PrescriptionController() {
        this.prescriptions = new ArrayList<>();
    }

    // 🩺 Thêm đơn thuốc mới
    public String addPrescription(Prescription prescription, String token) {
        if (token == null || token.isEmpty()) {
            return "❌ Invalid token. Access denied.";
        }
        prescriptions.add(prescription);
        return "✅ Prescription saved successfully!";
    }

    // 📋 Xem tất cả đơn thuốc
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // 🔍 Tìm đơn thuốc theo ID bệnh nhân
    public List<Prescription> getPrescriptionsByPatient(String patientId) {
        List<Prescription> result = new ArrayList<>();
        for (Prescription p : prescriptions) {
            if (p.getPatientId().equals(patientId)) {
                result.add(p);
            }
        }
        return result;
    }
}
