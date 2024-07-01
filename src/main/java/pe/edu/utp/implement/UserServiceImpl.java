package pe.edu.utp.implement;

import pe.edu.utp.model.RegistrationStatus;
import pe.edu.utp.model.User;
import pe.edu.utp.model.Applicant;
import pe.edu.utp.model.Registration;
import pe.edu.utp.repository.UserRepository;
import pe.edu.utp.repository.ApplicantRepository;
import pe.edu.utp.repository.RegistrationRepository;
import pe.edu.utp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        createApplicantForUser(savedUser);
        createRegistrationForUser(savedUser);
        return savedUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Applicant createApplicantForUser(User user) {
        Applicant applicant = new Applicant();
        applicant.setUser(user);
        applicant.setIdApplicant(user.getIdUser().toString()); // Use the user ID for the applicant ID
        return applicantRepository.save(applicant);
    }

    @Override
    public Registration createRegistrationForUser(User user) {
        Registration registration = new Registration();
        registration.setUser(user);
        registration.setRegistrationDate(new Date());
        registration.setStatus(RegistrationStatus.SOLICITADO);
        registration.setGrade(0L);
        registration.setStudyLevel("Inicial");
        return registrationRepository.save(registration);
    }


}
