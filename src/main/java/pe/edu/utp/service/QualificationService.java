package pe.edu.utp.service;

import pe.edu.utp.model.Qualification;
import pe.edu.utp.model.Student;

import java.util.List;

public interface QualificationService {
    List <Qualification> getQualificationsByStudentId(String idStudent);
}
