package pe.edu.utp.controller;

import org.springframework.http.ResponseEntity;
import pe.edu.utp.implement.AdminServiceImpl;
import pe.edu.utp.model.Admin;
import pe.edu.utp.model.Student;
import pe.edu.utp.model.Teacher;
import pe.edu.utp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.service.StudentService;
import pe.edu.utp.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/name/{name}")
    public List<Admin> getAdminsByName(@PathVariable String name) {
        return adminService.getAdminsByFullName(name);

    }

    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @PutMapping("/registration/{registrationId}/status")
    public void changeRegistrationStatus(@PathVariable Long registrationId, @RequestParam String status) {
        adminService.changeRegistrationStatus(registrationId, status);
    }
    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/teacherSave")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.addTeacher(teacher);
        return ResponseEntity.ok(newTeacher);
    }
}
