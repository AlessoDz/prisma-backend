package pe.edu.utp.service;

import pe.edu.utp.model.Student;
import pe.edu.utp.model.User;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(Student student);

    Student getStudentById(String id);

    List<Student> getAllStudents();

    List<Student> getStudentsByFullName(String name);

    Optional<User> getStudentByDni(String dni);

    Student updateStudent(Long id, Student student);

}
