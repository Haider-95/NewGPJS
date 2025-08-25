package se.systementor.supershoppen1.shop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import se.systementor.supershoppen1.shop.model.Product;
import se.systementor.supershoppen1.shop.model.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    ProductService(ProductRepository rep) {
        super();
        this.repository = rep;
    }

    public List<Product> getAll(){
        var l = new ArrayList<Product>();
        for(Product r : repository.findAll())
        {
            l.add(r);
        }
        return l;
    }

    public Product get(Integer id){
        return repository.findById(id).get();
    }

    public void save(Product product1) {
        repository.save(product1);
    }
}

