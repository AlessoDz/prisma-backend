package pe.edu.utp.controller;

import pe.edu.utp.implement.AdminServiceImpl;
import pe.edu.utp.model.Admin;
import pe.edu.utp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping("/save")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/name/{name}")
    public List<Admin> getAdminsByName(@PathVariable String name) {
        return adminServiceImpl.getAdminsByFullName(name);

    }

    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @PutMapping("/registration/{registrationId}/status")
    public void changeRegistrationStatus(@PathVariable Long registrationId, @RequestParam String status) {
        adminService.changeRegistrationStatus(registrationId, status);
    }
}
