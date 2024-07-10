package pe.edu.utp.service;


import pe.edu.utp.model.Activity;
import pe.edu.utp.model.Qualification;

import java.util.List;

public interface ActivityService {
    List <Activity> getActivitiesByStudentId(String idStudent);
}
