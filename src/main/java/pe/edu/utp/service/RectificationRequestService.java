package pe.edu.utp.service;


import pe.edu.utp.model.RectificationRequest;

import java.util.List;

public interface RectificationRequestService {
    List<RectificationRequest> getRectificationRequestsByStudentId(String idStudent);
    RectificationRequest createRectificationRequest(RectificationRequest request);
}

