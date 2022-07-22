package com.example.products.controllers;
import com.example.products.Services.StoreService;
import com.example.products.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/store")
    public List<Store> showStore() {
        return storeService.getAll();
    }

    @GetMapping("/store/{id}")
    public Store showOneStore(@PathVariable("id") int id) {
        return storeService.findOne(id);
    }

    @PostMapping("/store")
    public Store createStore(@RequestBody Store store) {
        return storeService.create(store);
    }

    @PutMapping("/store/{id}")
    public Store updateStore(@RequestBody Store store, @PathVariable("id") int id) {
        Store newStore = storeService.findOne(id);
        newStore.setName(store.getName());
        newStore.setLocation(store.getLocation());
        return storeService.create(newStore);
    }

    @DeleteMapping("/store/{id}")
    public void deleteStore(@PathVariable("id") int id) {
        storeService.delete(id);
    }

    @GetMapping("/store/name")
    public List<Store> getByName(@RequestParam String name) {
        return storeService.getByName(name);
    }

}
