package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.utp.model.Qualification;

import java.util.List;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    @Query(value = "CALL sp_find_qualifications_by_student_id(:id)", nativeQuery = true)
    List<Qualification> findQualificationsByStudentId(String id);
}
