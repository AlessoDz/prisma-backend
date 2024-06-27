package pe.edu.utp.service;

import pe.edu.utp.model.Applicant;

import java.util.Optional;

public interface ApplicantService {
    Applicant addApplicant(Applicant applicant);
    void deleteApplicant(Long id);
    Optional<Applicant> findApplicantByIdApplicant(String idApplicant);
}
