package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.utp.model.RectificationRequest;

import java.util.List;

public interface RectificationRequestRepository extends JpaRepository<RectificationRequest, String> {
    @Query(value = "CALL sp_find_student_by_id(:id)", nativeQuery = true)
    List<RectificationRequest> findRectificationRequestByStudentId(String id);
}
