package con.antsrl.springdemo.controller;

import con.antsrl.springdemo.model.Product;
import con.antsrl.springdemo.repository.ProductRepository;
import con.antsrl.springdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    final ProductRepository repository;
    final ProductService service;


    @GetMapping
    public Iterable<Product> get(@RequestParam(required = false) String name) {
        if (name != null)
            return repository.findAllByName(name);
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> get(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable Long id, @RequestBody Product product) {
        try {
            var updatedProduct = service.edit(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
