package pe.edu.utp.service;

import pe.edu.utp.model.User;
import pe.edu.utp.model.Applicant;
import pe.edu.utp.model.Registration;

public interface UserService {

    User saveUser(User user);

    void deleteUser(Long id);

    Applicant createApplicantForUser(User user);

    Registration createRegistrationForUser(User user);

}
