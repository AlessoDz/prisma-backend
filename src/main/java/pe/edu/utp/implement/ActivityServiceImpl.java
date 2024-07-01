package pe.edu.utp.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.Activity;
import pe.edu.utp.repository.ActivityRepository;
import pe.edu.utp.service.ActivityService;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List<Activity> getActivitiesByStudentId(Long studentId) {
        return activityRepository.findByStudentId(studentId);
    }
}

