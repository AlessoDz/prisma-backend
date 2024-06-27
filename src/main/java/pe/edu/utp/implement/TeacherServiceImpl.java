package pe.edu.utp.implement;

import pe.edu.utp.model.Teacher;
import pe.edu.utp.model.User;
import pe.edu.utp.repository.TeacherRepository;
import pe.edu.utp.repository.UserRepository;
import pe.edu.utp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        User user = teacher.getUser();
        teacher.setIdTeacher(generateTeacherId());
        user.setType("TEACHER");
        user.setActive(true);
        user = userServiceImpl.saveUser(user);
        teacher.setUser(user);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherRepository.findTeacherById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> getTeachersByFullName(String name) {
        return teacherRepository.findTeachersByFullName(name);
    }

    @Override
    public Optional<User> getTeacherByDni(String dni) {
        return userRepository.findByDni(dni);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update user details
            existingUser.setName(teacher.getUser().getName());
            existingUser.setLastName(teacher.getUser().getLastName());
            existingUser.setEmail(teacher.getUser().getEmail());
            existingUser.setPhone(teacher.getUser().getPhone());

            // Update teacher details
            Teacher existingTeacher = existingUser.getTeacher();
            existingTeacher.setPassword(teacher.getPassword());
            existingTeacher.setProfile(teacher.getProfile());
            existingTeacher.setSpeciality(teacher.getSpeciality());

            // Save changes
            return teacherRepository.save(existingTeacher);
        }
        return null;
    }

    private String generateTeacherId() {
        String lastTeacherId = teacherRepository.findLastTeacherId();
        if (lastTeacherId == null) {
            return "T240000001";
        }

        String sequence = lastTeacherId.substring(3);
        int sequenceNumber = Integer.parseInt(sequence);
        sequenceNumber++;

        return "T24" + String.format("%07d", sequenceNumber);
    }
}
