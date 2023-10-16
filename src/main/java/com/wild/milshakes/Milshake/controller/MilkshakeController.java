package com.wild.milshakes.Milshake.controller;

import com.wild.milshakes.Milshake.entity.Milkshake;
import com.wild.milshakes.Milshake.repository.MilkshakeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MilkshakeController {

    private final MilkshakeRepository repository;

    public MilkshakeController(MilkshakeRepository repositoryInjected) {

        this.repository = repositoryInjected;
    }


    @GetMapping("/milkshakes")
    public String getAll(Model model) {

        model.addAttribute("milkshakes", repository.findAll());

        return "milkshakes";
    }

    @GetMapping("milkshake")
    public String getMilkshake(Model model,
                               @RequestParam(required = false) Long id) {
        Milkshake milkshake = new Milkshake();
        if (id != null) {

            Optional<Milkshake> optionalMilkshake = repository.findById(id);
            if (optionalMilkshake.isPresent()) {
                milkshake = optionalMilkshake.get();
            }
        }
        model.addAttribute("milkshake", milkshake);

        return "milkshake";
    }


    @PostMapping("/milkshake")
    public String postMilkshake(@ModelAttribute Milkshake milkshake) {

        repository.save(milkshake);

        return "redirect:/milkshakes";
    }

    @GetMapping("/milkshake/delete")
    public String deleteMilkshake(@RequestParam Long id) {

        repository.deleteById(id);

        return "redirect:/milkshakes";
    }

}
