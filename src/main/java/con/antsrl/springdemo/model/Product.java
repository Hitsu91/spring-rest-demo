package con.antsrl.springdemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // Entity => modello con persistenza
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // In pratica auto increment
    private Long id;
    private String name;
    private Double price;
}
