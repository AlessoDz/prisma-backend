package pe.edu.utp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.model.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByStudentId(Long studentId);
}
