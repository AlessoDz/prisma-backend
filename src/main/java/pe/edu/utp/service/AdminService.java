package pe.edu.utp.service;

import pe.edu.utp.model.Admin;

import java.util.List;

public interface AdminService {

    Admin addAdmin(Admin admin);

    List<Admin> getAllAdmins();

    List<Admin> getAdminsByFullName(String name);

    Admin updateAdmin(Long id, Admin admin);

    void changeRegistrationStatus(Long registrationId, String status);
}
