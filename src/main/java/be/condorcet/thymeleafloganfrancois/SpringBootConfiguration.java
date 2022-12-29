package be.condorcet.thymeleafloganfrancois;

import be.condorcet.thymeleafloganfrancois.services.*;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfiguration {
    @Value("${server.mode}")
    private String mode;
    @Bean
    InterfEmployeService EmployeServiceImpl() {
        System.out.println("création du service client en mode : "+mode);
        switch (mode){
            case "PROD" : return new EmployeServiceImpl();
            default: return new EmployeServiceImpl();
        }
    }
    @Bean
    InterfProjetService ProjetServiceImpl() {
        System.out.println("création du service client en mode : "+mode);
        switch (mode){
            case "PROD" : return new ProjetServiceImpl();
            default: return new ProjetServiceImpl();

        }
    }
}
