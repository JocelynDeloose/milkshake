package com.wild.milshakes.Milshake.controller;

import com.wild.milshakes.Milshake.entity.Milkshake;
import com.wild.milshakes.Milshake.entity.Seller;
import com.wild.milshakes.Milshake.repository.SellerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class SellerController {

    private final SellerRepository repository;

    public SellerController (SellerRepository repositoryInjected){

        this.repository = repositoryInjected;
    }


    @GetMapping("/sellers")
    public List<Seller> getAll(){
        return this.repository.findAll();
    }

    @GetMapping("/seller")
    public ResponseEntity<Seller> getSeller(
                               @RequestParam(required = false) Long id) {

            Optional<Seller> optionalSeller = repository.findById(id);
            if (optionalSeller.isPresent()) {

                Seller seller = optionalSeller.get();
                return ResponseEntity.ok().body(seller);
            }


        return ResponseEntity.notFound().build();
    }


    @PostMapping("/seller")
    public Seller postMilkshake(@RequestBody Seller seller) {

        return this.repository.save(seller);
    }


    @PutMapping("/seller/{id}")
    public ResponseEntity<Seller> update(@PathVariable Long id, @RequestBody Seller updateSeller) {
        Optional<Seller> optionalSeller = repository.findById(id);

        if (optionalSeller.isPresent()) {

            Seller seller = optionalSeller.get();

            seller.setName(updateSeller.getName());
            seller.setAge(updateSeller.getAge());

            return ResponseEntity.ok(repository.save(seller));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("seller/{id}")
    public boolean delete(@PathVariable Long id) {

        repository.deleteById(id);
        return true;
    }

}
