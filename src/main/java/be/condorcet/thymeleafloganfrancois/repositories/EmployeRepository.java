package be.condorcet.thymeleafloganfrancois.repositories;
import be.condorcet.thymeleafloganfrancois.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Integer>{


    List<Employe> findEmployesByNomLike(String s);

}
