package pe.edu.utp.service;

import pe.edu.utp.model.Teacher;
import pe.edu.utp.model.User;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);

    Teacher getTeacherById(String id);

    List<Teacher> getAllTeachers();

    List<Teacher> getTeachersByFullName(String name);

    Optional<User> getTeacherByDni(String dni);

    Teacher updateTeacher(Long id, Teacher teacher);
}
