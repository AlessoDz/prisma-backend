package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.model.Qualification;
import java.util.List;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findByStudentId(Long studentId);
}