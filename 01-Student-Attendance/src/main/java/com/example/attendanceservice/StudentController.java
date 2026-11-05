package com.example.attendanceservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/api/attendance") public class StudentController {
 private final AttendanceService service;public StudentController(AttendanceService s){service=s;}
 @GetMapping public List<Attendance> list(){return service.list();}
 @GetMapping("/{id}") public Attendance get(@PathVariable Long id){return service.get(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Attendance add(@RequestBody Attendance a){return service.add(a);}
 @PutMapping("/{id}") public Attendance update(@PathVariable Long id,@RequestBody Attendance a){return service.update(id,a);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}
