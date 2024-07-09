package pe.edu.utp.controller;

import pe.edu.utp.implement.ActivityServiceImpl;
import pe.edu.utp.implement.StudentServiceImpl;
import pe.edu.utp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.service.ActivityService;
import pe.edu.utp.service.CourseService;
import pe.edu.utp.service.QualificationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    private CourseService courseService;

    @Autowired
    private QualificationService qualificationService;

    @Autowired
    private ActivityService activityService;

    @PostMapping("/save")
    public ResponseEntity<Student> createdStudent(@RequestBody Student student) {
        Student newStudent = studentServiceImpl.addStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentServiceImpl.getStudentsByFullName(name);
    }

    @GetMapping("/dni/{dni}")
    public Optional<User> getStudentByDni(@PathVariable String dni) {
        return studentServiceImpl.getStudentByDni(dni);
    }

    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentServiceImpl.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentServiceImpl.updateStudent(id, student));
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/id/qualifications")
    public List<Qualification> getQualifications(@RequestParam String idStudent) {
        return qualificationService.getQualificationsByStudentId(idStudent);
    }

    @GetMapping("/activities")
    public List<Activity> getActivities(@RequestParam Long studentId) {
        return activityService.getActivitiesByStudentId(studentId);
    }


}
