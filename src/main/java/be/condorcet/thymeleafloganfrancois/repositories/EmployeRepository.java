package be.condorcet.thymeleafloganfrancois.repositories;
import be.condorcet.thymeleafloganfrancois.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Integer>{

    public Optional<Employe> findById(Integer id);
    List<Employe> findEmployesByNomLike(String s);

    List<Employe> findByNomLike (String nom);
    Employe findEmployesByMatriculeAndNomAndPrenom (String matricule, String nom, String prenom);

}
