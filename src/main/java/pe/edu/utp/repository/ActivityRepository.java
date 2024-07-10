package pe.edu.utp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.utp.model.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query(value = "CALL sp_get_activities_by_student(:id)", nativeQuery = true)
    List<Activity> findActivitiesByStudentId(String id);
}
