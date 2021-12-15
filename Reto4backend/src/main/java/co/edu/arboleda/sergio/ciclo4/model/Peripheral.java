
package co.edu.arboleda.sergio.ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase Crea la tabla peripherals
 * @since 11-12-2021
 * @version 1.0
 * @author Grupo 4 subgrupo 2
 */
@Document(collection = "peripherals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Peripheral {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String description;
    private double price;
    private boolean availability = true;
    private int quantity;
    private String photography;

}
