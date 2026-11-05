package com.example.attendanceservice;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity public class Attendance {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long studentId; private String course; private LocalDate attendanceDate; private boolean present;
 public Long getId(){return id;} public Long getStudentId(){return studentId;} public void setStudentId(Long v){studentId=v;} public String getCourse(){return course;} public void setCourse(String v){course=v;} public LocalDate getAttendanceDate(){return attendanceDate;} public void setAttendanceDate(LocalDate v){attendanceDate=v;} public boolean isPresent(){return present;} public void setPresent(boolean v){present=v;}
}
