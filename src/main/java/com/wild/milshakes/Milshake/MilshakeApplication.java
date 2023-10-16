package com.wild.milshakes.Milshake;

import com.wild.milshakes.Milshake.entity.Milkshake;
import com.wild.milshakes.Milshake.entity.Seller;
import com.wild.milshakes.Milshake.repository.MilkshakeRepository;
import com.wild.milshakes.Milshake.repository.SellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MilshakeApplication {

	private final MilkshakeRepository milkshakeRepository;
	private final SellerRepository sellerRepository;

	public MilshakeApplication(MilkshakeRepository milkshakeRepository, SellerRepository sellerRepository){

		this.milkshakeRepository = milkshakeRepository;
		this.sellerRepository = sellerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MilshakeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (String[] args) -> {

			Milkshake milkShake1 = new Milkshake("BananaSunrise", 0, "Banana");
			milkshakeRepository.save(milkShake1);
			Milkshake milkShake2 = new Milkshake("Heavy StrawBerry", 200, "strawberry");
			milkshakeRepository.save(milkShake2);
			Milkshake milkShake3 = new Milkshake("CocoChanel", 200, "Coconut's");
			milkshakeRepository.save(milkShake3);
			Milkshake milkShake4 = new Milkshake("VanillaSky", 200, "Vanilla");
			milkshakeRepository.save(milkShake4);

			Seller seller1 = new Seller("John", 18);
			Seller seller2 = new Seller("Doe", 1000);
			sellerRepository.save(seller1);
			sellerRepository.save(seller2);
		};
	}
}
