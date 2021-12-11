package Retos_Ciclo4.Retos_Ciclo4.controller;

import Retos_Ciclo4.Retos_Ciclo4.model.Admin;
import Retos_Ciclo4.Retos_Ciclo4.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id) {
        return adminService.getAdmin(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return adminService.delete(id);
    }

    @GetMapping("/{email}/{password}")
    public Admin authenticateAdmin(@PathVariable("email") String email, @PathVariable("password") String password) {
        return adminService.authenticateAdmin(email, password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return adminService.emailExists(email);
    }
}
