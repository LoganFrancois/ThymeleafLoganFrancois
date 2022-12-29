package be.condorcet.thymeleafloganfrancois.services;

import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface InterfProjetService extends InterfService<Projet>{

    public List<Projet> getProjets(Employe emp);
}
