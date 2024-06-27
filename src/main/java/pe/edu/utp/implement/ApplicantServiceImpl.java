package pe.edu.utp.implement;

import pe.edu.utp.model.Applicant;
import pe.edu.utp.repository.ApplicantRepository;
import pe.edu.utp.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Applicant addApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public void deleteApplicant(Long idApplicant) {
        applicantRepository.deleteById(idApplicant);
    }

    @Override
    public Optional<Applicant> findApplicantByIdApplicant(String idApplicant) {
        return applicantRepository.findByIdApplicant(idApplicant);
    }
}
