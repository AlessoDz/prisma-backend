package pe.edu.utp.repository;

import pe.edu.utp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "CALL sp_find_student_by_full_name(:name)", nativeQuery = true)
    List<Student> findStudentsByFullName (String name);

    @Query(value = "CALL sp_find_student_by_id(:id)", nativeQuery = true)
    Student findStudentById(String id);

    @Query(value = "CALL sp_find_last_student_id()", nativeQuery = true)
    String findLastStudentId();

}
