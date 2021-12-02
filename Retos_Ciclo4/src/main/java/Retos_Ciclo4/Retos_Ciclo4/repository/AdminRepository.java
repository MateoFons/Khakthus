package Retos_Ciclo4.Retos_Ciclo4.repository;

import Retos_Ciclo4.Retos_Ciclo4.crud.AdminInterface;
import Retos_Ciclo4.Retos_Ciclo4.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminInterface adminInterface;

    /**
     * Metodo para listar todos los usuarios
     *
     * @return lista de usuarios
     */
    public List<Admin> getAll() {
        return (List<Admin>) adminInterface.findAll();
    }

    /**
     * Metodo para buscar usuario por id
     *
     * @param id
     * @return usuario
     */
    public Optional<Admin> getAdmin(int id) {
        return adminInterface.findById(id);
    }

    /**
     * Metodo para guardar registro de un usuario
     *
     * @param admin
     * @return usuario
     */
    public Admin create(Admin admin) {
        return adminInterface.save(admin);
    }

    /**
     * Metodo para actualizar registro de un usuario
     *
     * @param admin
     */
    public void update(Admin admin) {
        adminInterface.save(admin);
    }

    /**
     * Metodo para borrar registro de un usuario
     *
     * @param admin
     */
    public void delete(Admin admin) {
        adminInterface.delete(admin);
    }

    /**
     * Metodo para validar si existe un usuario por el correo
     *
     * @param email
     * @return boolean
     */
    public boolean emailExists(String email) {
        Optional<Admin> administrator = adminInterface.findByEmail(email);
        return !administrator.isEmpty();
    }

    /**
     * Metodo para autenticar credenciales de usuario
     *
     * @param email
     * @param password
     * @return usuario
     */
    public Optional<Admin> authenticateAdmin(String email, String password) {
        return adminInterface.findByEmailAndPassword(email, password);
    }
}
