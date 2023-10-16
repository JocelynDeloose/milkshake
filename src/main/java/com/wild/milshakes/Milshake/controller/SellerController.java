package com.wild.milshakes.Milshake.controller;

import com.wild.milshakes.Milshake.entity.Milkshake;
import com.wild.milshakes.Milshake.entity.Seller;
import com.wild.milshakes.Milshake.repository.SellerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class SellerController {

    private final SellerRepository repository;

    public SellerController (SellerRepository repositoryInjected){

        this.repository = repositoryInjected;
    }


    @GetMapping("/sellers")
    public String getAll(Model model) {

        model.addAttribute("sellers", repository.findAll());

        return "sellers";
    }

    @GetMapping("seller")
    public String getSeller(Model model,
                               @RequestParam(required = false) Long id) {
        Seller seller = new Seller();
        if (id != null) {

            Optional<Seller> optionalSeller = repository.findById(id);
            if (optionalSeller.isPresent()) {
                seller = optionalSeller.get();
            }
        }
        model.addAttribute("seller", seller);

        return "seller";
    }


    @PostMapping("/seller")
    public String postSeller(@ModelAttribute Seller seller) {

        repository.save(seller);

        return "redirect:/sellers";
    }

    @GetMapping("/seller/delete")
    public String deleteSeller(@RequestParam Long id) {

        repository.deleteById(id);

        return "redirect:/sellers";
    }

}
