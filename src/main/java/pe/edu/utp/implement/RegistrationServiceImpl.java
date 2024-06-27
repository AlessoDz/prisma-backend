package pe.edu.utp.implement;

import pe.edu.utp.model.*;
import pe.edu.utp.repository.*;
import pe.edu.utp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Override
    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }
    @Autowired
    private ApplicantServiceImpl applicantServiceImpl;

    @Override
    public void changeRegistrationStatus(Long registrationId, String status) {
        Optional<Registration> optionalRegistration = registrationRepository.findById(registrationId);
        if (optionalRegistration.isPresent()) {
            Registration registration = optionalRegistration.get();
            registration.setStatus(RegistrationStatus.valueOf(status));
            registrationRepository.save(registration);

            if (registration.getStatus() == RegistrationStatus.COMPLETADO) {
                User user = registration.getUser();
                Student student = new Student();
                student.setUser(user);
                student.setGrade(registration.getGrade());
                student.setStudyLevel(registration.getStudyLevel());
                studentServiceImpl.addStudent(student);
                applicantServiceImpl.deleteApplicant(Long.valueOf(user.getApplicant().getIdApplicant()));
            } else if (registration.getStatus() == RegistrationStatus.DENEGADO) {
                applicantServiceImpl.deleteApplicant(Long.valueOf(registration.getUser().getApplicant().getIdApplicant()));
            }
        }
    }
    @Override
    public Optional<Registration> findByIdRegistration(Long idRegistration) {
        return registrationRepository.findByIdRegistration(idRegistration);
    }

    @Override
    public void updateRegistration(Long registrationId, Registration registration) {
        Optional<Registration> existingRegistration = registrationRepository.findById(registrationId);
        if (existingRegistration.isPresent()) {
            Registration reg = existingRegistration.get();
            reg.setGrade(registration.getGrade());
            reg.setStudyLevel(registration.getStudyLevel());
            reg.setStatus(registration.getStatus());
            registrationRepository.save(reg);
        }
    }
}
