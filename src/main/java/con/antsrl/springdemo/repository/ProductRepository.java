package con.antsrl.springdemo.repository;

import con.antsrl.springdemo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository è il Data Access layer
// Con spring data jpa, abbiamo la maggior parte dei metodi generici di accesso al db
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // Se abbiamo bisogno di query custom, nella maggior parte del tempo possiamo usare le firme sfruttanto i "named query"
    // Esempio ricarca per nome:
    List<Product> findAllByName(String name);
}
