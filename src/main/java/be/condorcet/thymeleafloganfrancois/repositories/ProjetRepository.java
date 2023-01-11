package be.condorcet.thymeleafloganfrancois.repositories;

import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {
    public Optional<Projet> findById(Integer id);

    public List<Projet> findProjetByEmploye(Employe emp);

    public List<Projet>findProjetByNomprojStartingWith(String nom);

   public List<Projet> findProjetByCoutGreaterThanEqual(BigDecimal cout);
}
