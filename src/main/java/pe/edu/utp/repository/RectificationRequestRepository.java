package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.model.RectificationRequest;

import java.util.List;

public interface RectificationRequestRepository extends JpaRepository<RectificationRequest, Long> {
    List<RectificationRequest> findByStudentId(Long studentId);
}
