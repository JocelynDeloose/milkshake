package com.wild.milshakes.Milshake.controller;

import com.wild.milshakes.Milshake.entity.Milkshake;
import com.wild.milshakes.Milshake.repository.MilkshakeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@RestController
public class MilkshakeController {

    private final MilkshakeRepository repository;

    public MilkshakeController(MilkshakeRepository repositoryInjected) {

        this.repository = repositoryInjected;
    }


    @GetMapping("/milkshakes")
    public List<Milkshake> getAll() {

        return this.repository.findAll();
    }

    @GetMapping("milkshake")
    public ResponseEntity<Milkshake> getMilkshake(@RequestParam(required = false) Long id) {

        Optional<Milkshake> optionalMilkshake = repository.findById(id);

        if (optionalMilkshake.isPresent()) {

            Milkshake milkshake = optionalMilkshake.get();

            return ResponseEntity.ok().body(milkshake);
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/milkshake")
    public Milkshake postMilkshake(@RequestBody Milkshake milkshake) {

        return this.repository.save(milkshake);


    }

    @PutMapping("/milkshake/{id}")
    public ResponseEntity<Milkshake> update(@PathVariable Long id, @RequestBody Milkshake uptadeMilkshake) {
        Optional<Milkshake> optionalMilkshake = repository.findById(id);

        if (optionalMilkshake.isPresent()) {

            Milkshake milkshake = optionalMilkshake.get();

            milkshake.setName(uptadeMilkshake.getName());
            milkshake.setQuantity(uptadeMilkshake.getQuantity());
            milkshake.setMainIngredient(uptadeMilkshake.getMainIngredient());


            return ResponseEntity.ok(repository.save(milkshake));
        }

            return ResponseEntity.notFound().build();

    }


    @DeleteMapping("milkshake/{id}")
    public boolean delete(@PathVariable Long id) {

        repository.deleteById(id);
        return true;
    }

}
