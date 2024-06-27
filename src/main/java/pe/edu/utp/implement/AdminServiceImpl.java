package pe.edu.utp.implement;

import pe.edu.utp.model.*;
import pe.edu.utp.repository.*;
import pe.edu.utp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public Admin addAdmin(Admin admin) {
        User user = admin.getUser();
        admin.setIdAmin(generateAdminId());
        user.setType("ADMIN");
        user.setActive(true);
        user = userServiceImpl.saveUser(user);
        admin.setUser(user);
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> getAdminsByFullName(String name) {
        return adminRepository.findAdminsByFullName(name);
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Optional<User> existingAdmin = userRepository.findById(id);
        if (existingAdmin.isPresent()) {
            Admin admin1 = existingAdmin.get().getAdmin();
            admin1.getUser().setName(admin.getUser().getName());
            admin1.getUser().setLastName(admin.getUser().getLastName());
            admin1.getUser().setEmail(admin.getUser().getEmail());
            admin1.getUser().setPhone(admin.getUser().getPhone());
            admin1.setProfile(admin1.getProfile());

            return adminRepository.save(admin1);
        }
        return null;
    }

    @Override
    public void changeRegistrationStatus(Long registrationId, String status) {
        Optional<Registration> optionalRegistration = registrationRepository.findById(registrationId);
        if (optionalRegistration.isPresent()) {
            Registration registration = optionalRegistration.get();
            registration.setStatus(RegistrationStatus.valueOf(status));
            registrationRepository.save(registration);

            if (registration.getStatus() == RegistrationStatus.COMPLETADO) {
                convertApplicantToStudent(registration.getUser());
            } else if (registration.getStatus() == RegistrationStatus.DENEGADO) {
                deleteApplicant(registration.getUser());
            }
        }
    }

    private void convertApplicantToStudent(User user) {
        Applicant applicant = user.getApplicant();
        if (applicant != null) {
            applicantRepository.delete(applicant);

            Student student = new Student();
            student.setIdStudent(generateStudentId());
            student.setUser(user);

            studentRepository.save(student);

            user.setStudent(student);
            userRepository.save(user);
        }
    }

    private void deleteApplicant(User user) {
        Applicant applicant = user.getApplicant();
        if (applicant != null) {
            applicantRepository.delete(applicant);
        }
        userRepository.delete(user);
    }

    private String generateAdminId() {
        String lastAdminId = adminRepository.findLastAdminId();
        if (lastAdminId == null) {
            return "A240000001";
        }

        String sequence = lastAdminId.substring(3);
        int sequenceNumber = Integer.parseInt(sequence);
        sequenceNumber++;

        return "A24" + String.format("%07d", sequenceNumber);
    }

    private String generateStudentId() {
        String lastStudentId = studentRepository.findLastStudentId();
        if (lastStudentId == null) {
            return "S240000001";
        }

        String sequence = lastStudentId.substring(3);
        int sequenceNumber = Integer.parseInt(sequence);
        sequenceNumber++;

        return "S24" + String.format("%07d", sequenceNumber);
    }
}
