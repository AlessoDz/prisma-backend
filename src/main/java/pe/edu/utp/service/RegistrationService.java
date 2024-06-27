package pe.edu.utp.service;

import pe.edu.utp.model.Registration;

import java.util.Optional;

public interface RegistrationService {
    Registration saveRegistration(Registration registration);
    void changeRegistrationStatus(Long registrationId, String status);
    Optional<Registration> findByIdRegistration(Long idRegistration);
    void updateRegistration(Long registrationId, Registration registration);
}
