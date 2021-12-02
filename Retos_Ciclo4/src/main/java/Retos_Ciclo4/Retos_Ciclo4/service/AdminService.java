package Retos_Ciclo4.Retos_Ciclo4.service;

import Retos_Ciclo4.Retos_Ciclo4.model.Admin;
import Retos_Ciclo4.Retos_Ciclo4.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    /**
     * Metodo para listar todos los usuarios
     *
     * @return lista de usuarios
     */
    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    /**
     * Metodo para buscar usuario por id
     *
     * @param id
     * @return usuario
     */
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    /**
     * Metodo para guardar registro de un usuario
     *
     * @param admin
     * @return admin
     */
    public Admin create(Admin admin) {
        if (admin.getId() == null) {
            if (emailExists(admin.getEmail()) == false) {
                return adminRepository.create(admin);
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    /**
     * Metodo para actualizar registro de un usuario
     *
     * @param admin
     * @return admin
     */
    public Admin update(Admin admin) {
        if (admin.getId() != null) {
            Optional<Admin> adminDb = adminRepository.getAdmin(admin.getId());
            if (!adminDb.isEmpty()) {
                if (admin.getName() != null) {
                    adminDb.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    adminDb.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    adminDb.get().setPassword(admin.getPassword());
                }
                adminRepository.update(adminDb.get());
                return adminDb.get();
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    public boolean delete(int adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Metodo para validar si existe un usuario por el correo
     *
     * @param email
     * @return boolean
     */
    public boolean emailExists(String email) {
        return adminRepository.emailExists(email);
    }

    /**
     * Metodo para autenticar credenciales de usuario
     *
     * @param email
     * @param password
     * @return admin
     */
    public Admin authenticateAdmin(String email, String password) {
        Optional<Admin> administrator = adminRepository.authenticateAdmin(email, password);
        if (administrator.isEmpty()) {
            return new Admin();
        } else {
            return administrator.get();
        }
    }
}
