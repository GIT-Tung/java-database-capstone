# MySQL Database Design – Doctor-Patient Management System

## Overview
This schema supports three main roles: **Admin**, **Doctor**, and **Patient**.  
It allows management of users, appointments, and medical records.

---

## Tables

### 1. `users`
Stores login credentials and role information for all system users.

| Field        | Type         | Constraints              | Description |
|---------------|--------------|---------------------------|--------------|
| user_id       | INT          | PRIMARY KEY AUTO_INCREMENT | Unique ID for each user |
| username      | VARCHAR(50)  | NOT NULL UNIQUE           | Login username |
| password      | VARCHAR(100) | NOT NULL                  | Hashed password |
| role          | ENUM('Admin', 'Doctor', 'Patient') | NOT NULL | User role |

---

### 2. `doctors`
| Field        | Type         | Constraints              | Description |
|---------------|--------------|---------------------------|--------------|
| doctor_id     | INT          | PRIMARY KEY AUTO_INCREMENT | Doctor unique ID |
| user_id       | INT          | FOREIGN KEY REFERENCES users(user_id) | Linked account |
| specialization| VARCHAR(100) | NOT NULL | Doctor’s specialty |
| phone         | VARCHAR(20)  | NULL | Doctor’s contact number |

---

### 3. `patients`
| Field        | Type         | Constraints              | Description |
|---------------|--------------|---------------------------|--------------|
| patient_id    | INT          | PRIMARY KEY AUTO_INCREMENT | Patient unique ID |
| user_id       | INT          | FOREIGN KEY REFERENCES users(user_id) | Linked account |
| date_of_birth | DATE         | NULL | Patient birth date |
| gender        | ENUM('Male', 'Female', 'Other') | NULL | Gender |
| phone         | VARCHAR(20)  | NULL | Contact number |

---

### 4. `appointments`
| Field          | Type        | Constraints | Description |
|----------------|-------------|-------------|--------------|
| appointment_id | INT | PRIMARY KEY AUTO_INCREMENT | Appointment unique ID |
| doctor_id      | INT | FOREIGN KEY REFERENCES doctors(doctor_id) | Doctor assigned |
| patient_id     | INT | FOREIGN KEY REFERENCES patients(patient_id) | Patient booked |
| appointment_date | DATETIME | NOT NULL | Date and time |
| status | ENUM('Pending', 'Completed', 'Cancelled') | DEFAULT 'Pending' | Appointment status |

---

### 5. `medical_records`
| Field          | Type        | Constraints | Description |
|----------------|-------------|-------------|--------------|
| record_id      | INT | PRIMARY KEY AUTO_INCREMENT | Record unique ID |
| patient_id     | INT | FOREIGN KEY REFERENCES patients(patient_id) | Related patient |
| doctor_id      | INT | FOREIGN KEY REFERENCES doctors(doctor_id) | Doctor who updated |
| diagnosis      | TEXT | NOT NULL | Diagnosis details |
| treatment      | TEXT | NULL | Treatment plan |
| created_at     | DATETIME | DEFAULT CURRENT_TIMESTAMP | Record creation time |

---

## Relationships
- One **User** → One **Doctor** OR One **Patient**  
- One **Doctor** → Many **Appointments**, Many **Records**  
- One **Patient** → Many **Appointments**, Many **Records**

---

## ERD (Conceptual)
