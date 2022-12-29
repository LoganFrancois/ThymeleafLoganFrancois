package be.condorcet.thymeleafloganfrancois.services;
import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.repositories.EmployeRepository;
import be.condorcet.thymeleafloganfrancois.services.InterfEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@Service
@Transactional(rollbackOn = Exception.class)
public class EmployeServiceImpl implements InterfEmployeService {
     @Autowired
     private EmployeRepository employeRepository;
      @Override
      public Employe create(Employe employe) throws Exception {
          employeRepository.save(employe);
          return employe;
      }
    @Override
    public Employe read(Integer id) throws Exception {
        Optional<Employe> ocl = employeRepository.findById(id);
        return ocl.get();
    }

    @Override
    public List<Employe> read(String nom) {
        return employeRepository.findEmployesByNomLike(nom);
    }

    @Override
    public List<Employe> SearchByNom(String nom) {
        return employeRepository.findByNomLike(nom);
    }

     @Override
     public Employe update(Employe emp) throws Exception {
         employeRepository.save(emp);
         return emp;
     }

     @Override
     public void delete(Employe emp) throws Exception {
         employeRepository.deleteById(emp.getIdemploye());
     }

     @Override
     public List<Employe> all() throws Exception {
         return employeRepository.findAll();
     }

    @Override
    public Employe read(String matricule, String nom, String prenom) {
        return employeRepository.findEmployesByMatriculeAndNomAndPrenom(matricule,nom,prenom);
    }

 }