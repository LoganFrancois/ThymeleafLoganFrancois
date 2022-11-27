package be.condorcet.thymeleafloganfrancois.webservices;


import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;
import be.condorcet.thymeleafloganfrancois.services.InterfProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projet")
public class RestProjet {

    @Autowired
    private InterfProjetService projetServiceImpl;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Projet> getProjet(@PathVariable(value = "id") int id)  throws Exception{
        System.out.println("Recherche du projet: " + id);
        Projet projet = projetServiceImpl.read(id);
        return new ResponseEntity<>(projet, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) throws Exception {
        System.out.println("Création du projet: " + projet.getIdprojet());
        projetServiceImpl.create(projet);
        return new ResponseEntity<>(projet, HttpStatus.OK);
    }

    //-------------------Retrouver tous les projets --------------------------------------------------------
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseEntity<List<Projet>> listProjets() throws Exception{
        System.out.println
                ("recherche de tous les employés");
        return new ResponseEntity<>(projetServiceImpl.all(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Projet> updateProjet(@PathVariable(value = "id") int id, @RequestBody Projet newProjet) throws Exception{
        System.out.println("Mise à jour du projet portant l'id: " + id);
        newProjet.setIdprojet(id);
        Projet updatedProjet = projetServiceImpl.update(newProjet);
        return new ResponseEntity<>(updatedProjet, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delProjet(@PathVariable(value = "id") int id) throws Exception{
        System.out.println("Effacement du projet: " + id);
        Projet projet = projetServiceImpl.read(id);
        projetServiceImpl.delete(projet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void>  handleIOException(Exception ex) {
        System.out.println("Erreur : " + ex.getMessage());
        return ResponseEntity.notFound().header("error",ex.getMessage()).build();
    }
}
