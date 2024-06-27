package pe.edu.utp.controller;

import pe.edu.utp.implement.TeacherServiceImpl;
import pe.edu.utp.model.Teacher;
import pe.edu.utp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherServiceImpl.addTeacher(teacher);
        return ResponseEntity.ok(newTeacher);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherServiceImpl.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/name/{name}")
    public List<Teacher> getTeachersByName(@PathVariable String name) {
        return teacherServiceImpl.getTeachersByFullName(name);
    }

    @GetMapping("/dni/{dni}")
    public Optional<User> getTeacherByDni(@PathVariable String dni) {
        return teacherServiceImpl.getTeacherByDni(dni);
    }

    @GetMapping("/id/{id}")
    public Teacher getTeacherById(@PathVariable String id) {
        return teacherServiceImpl.getTeacherById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherServiceImpl.updateTeacher(id, teacher));
    }
}
