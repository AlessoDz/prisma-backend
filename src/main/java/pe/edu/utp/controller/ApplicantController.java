package pe.edu.utp.controller;

import pe.edu.utp.model.Applicant;
import pe.edu.utp.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/save")
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.addApplicant(applicant);
    }

    @GetMapping("/dni/{dni}")
    public Applicant getApplicantByDni(@PathVariable String dni) {
        return applicantService.findApplicantByIdApplicant(dni).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
    }
}
