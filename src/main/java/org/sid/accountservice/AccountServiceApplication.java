package org.sid.accountservice;

import org.sid.accountservice.entities.Compte;
import org.sid.accountservice.enums.TypeCompte;
import org.sid.accountservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(new Compte(null, 99900, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 77752, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 75899, new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(cp->{
                System.out.println(cp.getType());
                System.out.println(cp.getSolde());
            });
        };
    }

}
