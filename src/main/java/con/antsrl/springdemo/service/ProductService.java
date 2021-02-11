package con.antsrl.springdemo.service;

import con.antsrl.springdemo.model.Product;
import con.antsrl.springdemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Un service è praticamente il layer della businness logic
// invece di esporre direttamente il data access, posso in caso ci sia necessità sarebbe meglio
// implementare la business logic apposita
@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository repository;

    // Solo dimostrazione di come funziona un service
    public Product edit(Long id, Product product) throws Exception {
        var old = repository.findById(id);
        if (old.isPresent()) {
            if (old.get().getId().equals(product.getId())) {
                // Il save fa anche da update se l'id esiste già
                return repository.save(product);
            } else {
                throw new Exception("Id must be equals");
            }
        } else {
            // meglio gestire in modo diverso
            throw new Exception("Product not found");
        }
    }
}
