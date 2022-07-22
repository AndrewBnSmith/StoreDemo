package com.example.products.Services;

import com.example.products.models.Store;
import com.example.products.repositories.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    public Store create(Store store) {
        return storeRepository.save(store);
    }

    public Store findOne(int id) {
        return storeRepository.findById(id).get();
    }

    public Store update(Store store) {
        return storeRepository.save(store);
    }

    public void delete(int id) {
        storeRepository.deleteById(id);
    }

    public List<Store> getByName(String name){
        return storeRepository.findByName(name);
    }



}
