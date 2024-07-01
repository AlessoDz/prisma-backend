package pe.edu.utp.service;

import pe.edu.utp.model.Qualification;

import java.util.List;

public interface QualificationService {
    List<Qualification> getQualificationsByStudentId(Long studentId);
}
