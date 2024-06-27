package pe.edu.utp.repository;

import pe.edu.utp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    @Query(value = "CALL sp_find_user_by_dni(:dni)", nativeQuery = true)
    Optional<User> findByDni(String dni);

    @Query(value = "CALL sp_find_user_by_email(:email)", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
