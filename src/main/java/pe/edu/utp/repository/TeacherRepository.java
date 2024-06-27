package pe.edu.utp.repository;

import pe.edu.utp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "CALL sp_find_teacher_by_full_name(:name)", nativeQuery = true)
    List<Teacher> findTeachersByFullName (String name);

    @Query(value = "CALL sp_find_teacher_by_id(:id)", nativeQuery = true)
    Teacher findTeacherById(String id);

    @Query(value = "CALL sp_find_last_teacher_id()", nativeQuery = true)
    String findLastTeacherId();
}
