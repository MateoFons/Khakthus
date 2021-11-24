package ciclo4.model;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author GrupoDesarrollo
*/

/*
 Lombok es la anotacion que permite evitar el exceso de codigo al no tener que
 crear constructor, getters y setters
*/
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true ))
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NonNull
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;
    
    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    
    @NonNull
    @Column(name = "user_name", nullable = false, length = 50)
    private String name;
}
