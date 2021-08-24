package net.zerotodev.api.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication @RequiredArgsConstructor
public class CustomerApplication implements CommandLineRunner {
	private final CustomRepository customRepository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		customRepository.deleteAll();
		customRepository.save(new Customer("1", "Alice", "Smith"));
		customRepository.save(new Customer("2", "Bob", "Smith"));
		customRepository.save(new Customer("3", "Tom", "Cruise"));
		System.out.println("고객 이름 전부 찾기");

		for (Customer customer: customRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println("=== 종료 ===");
	}
}
