package pe.edu.utp.implement;

import pe.edu.utp.model.Applicant;
import pe.edu.utp.model.Student;
import pe.edu.utp.model.User;
import pe.edu.utp.repository.ApplicantRepository;
import pe.edu.utp.repository.StudentRepository;
import pe.edu.utp.repository.UserRepository;
import pe.edu.utp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ApplicantRepository applicantRepository;


    @Override
    public Student addStudent(Student student) {
        User user = student.getUser();
        student.setIdStudent(generateStudentId());
        student.setPaymentStatus(true);
        user.setType("STUDENT");
        user.setActive(true);

        user = userServiceImpl.saveUser(user);
        student.setUser(user);

        // Borrar Applicant una vez el Student es creado
        Optional<Applicant> optionalApplicant = applicantRepository.findByIdApplicant(user.getDni());
        if (optionalApplicant.isPresent()) {
            applicantRepository.delete(optionalApplicant.get());
        }

        return studentRepository.save(student);
    }


    @Override
    public Student getStudentById(String idStudent) {
        return studentRepository.findStudentById(idStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByFullName(String name) {
        return studentRepository.findStudentsByFullName(name);
    }

    @Override
    public Optional<User> getStudentByDni(String dni) {
        return userRepository.findByDni(dni);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update user details
            existingUser.setName(student.getUser().getName());
            existingUser.setLastName(student.getUser().getLastName());
            existingUser.setEmail(student.getUser().getEmail());
            existingUser.setPhone(student.getUser().getPhone());

            // Update student details
            Student existingStudent = existingUser.getStudent();
            existingStudent.setGrade(student.getGrade());
            existingStudent.setSection(student.getSection());
            existingStudent.setStudyLevel(student.getStudyLevel());
            existingStudent.setShift(student.getShift());
            existingStudent.setProfile(student.getProfile());

            // Save changes
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    private String generateStudentId() {
        String lastStudentId = studentRepository.findLastStudentId();
        if (lastStudentId == null) {
            return "E240000001";
        }

        String sequence = lastStudentId.substring(3);
        int sequenceNumber = Integer.parseInt(sequence);
        sequenceNumber++;

        return "E24" + String.format("%07d", sequenceNumber);
    }
}
