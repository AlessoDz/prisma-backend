package pe.edu.utp.service;


import pe.edu.utp.model.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> getActivitiesByStudentId(Long studentId);
}