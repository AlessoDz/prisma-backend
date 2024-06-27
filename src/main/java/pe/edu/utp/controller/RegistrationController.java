package pe.edu.utp.controller;

import pe.edu.utp.implement.RegistrationServiceImpl;
import pe.edu.utp.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @PostMapping("/save")
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationServiceImpl.saveRegistration(registration);
    }

    @Autowired
    private RegistrationServiceImpl registrationServiceImpl;

    @GetMapping("/status/{dni}")
    public Optional<Registration> getRegistrationStatusByDni(@PathVariable String dni) {
        return registrationServiceImpl.findByIdRegistration(Long.valueOf(dni));
    }

    @PutMapping("/update/{id}")
    public void updateRegistration(@PathVariable Long id, @RequestBody Registration registration) {
        registrationServiceImpl.updateRegistration(id, registration);
    }

    @PutMapping("/changeStatus/{id}")
    public void changeRegistrationStatus(@PathVariable Long id, @RequestParam String status) {
        registrationServiceImpl.changeRegistrationStatus(id, status);
    }
}
