package com.gabrielveras.nfeapi;

import com.gabrielveras.nfeapi.model.entity.NotaFiscal;
import com.gabrielveras.nfeapi.model.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class NfeApiApplication {

    @Bean
    public CommandLineRunner run(
            @Autowired NotaFiscalRepository notaFiscalRepository) {
        return args -> {
            NotaFiscal nf1 = NotaFiscal.builder().numeroNota(1).estabelecimento("Empresa 01").valorTotal(3412.35D).build();
            notaFiscalRepository.save(nf1);
            NotaFiscal nf2 = NotaFiscal.builder().numeroNota(2).estabelecimento("Empresa 02").valorTotal(12312.22D).build();
            notaFiscalRepository.save(nf2);
            NotaFiscal nf3 = NotaFiscal.builder().numeroNota(5).estabelecimento("Empresa 03").valorTotal(41324.12D).build();
            notaFiscalRepository.save(nf3);
            NotaFiscal nf4 = NotaFiscal.builder().numeroNota(6).estabelecimento("Empresa 04").valorTotal(1234.5D).build();
            notaFiscalRepository.save(nf4);
            NotaFiscal nf5 = NotaFiscal.builder().numeroNota(8).estabelecimento("Empresa 05").valorTotal(550.35D).build();
            notaFiscalRepository.save(nf5);
            NotaFiscal nf6 = NotaFiscal.builder().numeroNota(9).estabelecimento("Empresa 06").valorTotal(550.35D).build();
            notaFiscalRepository.save(nf6);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(NfeApiApplication.class, args);
    }

}
