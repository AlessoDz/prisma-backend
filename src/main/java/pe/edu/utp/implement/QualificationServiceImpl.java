package pe.edu.utp.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.model.Qualification;
import pe.edu.utp.repository.QualificationRepository;
import pe.edu.utp.service.QualificationService;

import java.util.List;

@Service
public class QualificationServiceImpl implements QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;


    @Override
    public List<Qualification> getQualificationsByStudentId(String idStudent) {
        return qualificationRepository.findQualificationsByStudentId(idStudent);
    }
}
