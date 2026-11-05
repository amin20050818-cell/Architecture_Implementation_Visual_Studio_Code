package com.example.attendanceservice;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service public class AttendanceService {
 private final AttendanceRepository repo;
 public AttendanceService(AttendanceRepository repo){this.repo=repo;}
 public List<Attendance> list(){return repo.findAll();}
 public Attendance add(Attendance a){return repo.save(a);}
 public Attendance get(Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Attendance not found"));}
 public Attendance update(Long id,Attendance a){Attendance old=get(id);old.setStudentId(a.getStudentId());old.setCourse(a.getCourse());old.setAttendanceDate(a.getAttendanceDate());old.setPresent(a.isPresent());return repo.save(old);}
 public void delete(Long id){repo.delete(get(id));}
}
