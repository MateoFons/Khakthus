package Retos_Ciclo4.Retos_Ciclo4.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    @Id
    private Integer id;
    private String email;
    private String password;
    private String name;
}