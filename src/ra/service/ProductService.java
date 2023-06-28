package ra.service;

import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService{
    private List<Product> products ;
    public ProductService() {
        products = new ArrayList<>();
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void findById(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

}
