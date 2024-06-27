package pe.edu.utp.controller;

import pe.edu.utp.implement.StudentServiceImpl;
import pe.edu.utp.model.Student;
import pe.edu.utp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Student> createdStudent(@RequestBody Student student) {
        Student newStudent = studentServiceImpl.addStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentServiceImpl.getAllStudents();
        return ResponseEntity.ok(students);
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

}
