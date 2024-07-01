package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.utp.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
