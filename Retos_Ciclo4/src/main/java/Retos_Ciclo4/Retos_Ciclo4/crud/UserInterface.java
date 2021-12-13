package Retos_Ciclo4.Retos_Ciclo4.crud;

import Retos_Ciclo4.Retos_Ciclo4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInterface extends MongoRepository <User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);

    Optional<User> findTopByOrderByIdDesc();
}
