package ra.service;

import ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements IService{
    private List<Catalog> catalogs ;
    public CatalogService() {
        catalogs = new ArrayList<>();
    }
    @Override
    public List<Catalog> getAll() {
        return catalogs;
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
