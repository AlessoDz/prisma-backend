package pe.edu.utp.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.RectificationRequest;
import pe.edu.utp.repository.RectificationRequestRepository;
import pe.edu.utp.service.RectificationRequestService;

import java.util.List;

@Service
public class RectificationRequestServiceImpl implements RectificationRequestService {
    @Autowired
    private RectificationRequestRepository rectificationRequestRepository;

    @Override
    public List<RectificationRequest> getRectificationRequestsByStudentId(String id) {
        return rectificationRequestRepository.findByStudentId(id);
    }

    @Override
    public RectificationRequest createRectificationRequest(RectificationRequest request) {
        return rectificationRequestRepository.save(request);
    }
}
