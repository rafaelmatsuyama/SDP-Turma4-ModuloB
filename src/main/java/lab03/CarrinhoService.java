package lab03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class CarrinhoService implements CommandLineRunner {
    @Autowired
    public CarrinhoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CarrinhoService.class, args);
    }

    @Override
    public void run(String... args) {
        Carrinho produto1 = new Carrinho(1, "PS 5", 2, 4999.99);
        repository.save(produto1);

        Carrinho produto2 = new Carrinho(2, "Camisa do PSG", 5, 399.90);
        repository.save(produto2);

        Carrinho produto3 = new Carrinho(3, "Apple Macbook Pro", 1, 17000.00);
        repository.save(produto3);

        Carrinho produto4 = new Carrinho(4, "Macallan 12", 10, 25000.00);
        repository.save(produto4);

        Carrinho produto5 = new Carrinho(5, "RTX 4190", 2, 18000.00);
        repository.save(produto5);

        repository.findAll().forEach(it -> System.out.println(it.toString()));
    }
}
