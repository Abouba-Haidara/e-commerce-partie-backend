package com.gescom.gescom.services;

import com.gescom.gescom.entities.Product;
import com.gescom.gescom.repositories.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository ;
    ProductServiceImpl(final ProductRepository repository) {
        this.repository = repository;
    }
    @Override
    public void createProduct(Product product) {
        this.repository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteProduct(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Product editProduct(Product product, long id) {

        Product p =  this.repository.getReferenceById(id);

        p.setCategory(product.getCategory());
        p.setTitle(product.getTitle());
        p.setPrice(product.getPrice());

        this.repository.save(p);

        return p;
    }

    @Override
    public Product findProduct(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void deleteProductAll() {
        this.repository.deleteAll();
    }
}
