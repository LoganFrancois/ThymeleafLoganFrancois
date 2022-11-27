package be.condorcet.thymeleafloganfrancois.services;
import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;

import java.awt.*;
import java.util.List;
import be.condorcet.thymeleafloganfrancois.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@Service
@Transactional(rollbackOn = Exception.class)
public class ProjetServiceImpl implements InterfProjetService{

    @Autowired
    private ProjetRepository projetRepository;
    @Override
    public Projet create(Projet projet) throws Exception {
        projetRepository.save(projet);
        return projet;
    }
    @Override
    public Projet read(Integer id) throws Exception {
        return projetRepository.findById(id).get();
    }
    @Override
    public Projet update(Projet projet) throws Exception {
        projetRepository.save(projet);
        return projet;
    }
    @Override
    public void delete(Projet projet) throws Exception {
        projetRepository.deleteById(projet.getIdprojet());
    }
    @Override
    public List<Projet> all() throws Exception {
        return projetRepository.findAll();
    }

}


