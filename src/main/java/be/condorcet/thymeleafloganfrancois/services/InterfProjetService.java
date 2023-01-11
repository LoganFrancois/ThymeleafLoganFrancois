package be.condorcet.thymeleafloganfrancois.services;

import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;


public interface InterfProjetService extends InterfService<Projet>{

    public List<Projet> getProjets(Employe emp);

    public List<Projet> getProjetsByNom(String nom);

    public List <Projet> getProjetsByCout(BigDecimal cout);
}

