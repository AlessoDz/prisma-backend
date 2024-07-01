package pe.edu.utp.controller;

import pe.edu.utp.model.Applicant;
import pe.edu.utp.model.Student;
import pe.edu.utp.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private StudentService studentService;

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
