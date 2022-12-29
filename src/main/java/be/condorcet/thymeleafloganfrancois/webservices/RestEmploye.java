package be.condorcet.thymeleafloganfrancois.webservices;

import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.services.InterfEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
@RestController
@RequestMapping("/employes")
public class RestEmploye {
    @Autowired
    private InterfEmployeService employeServiceImpl;

    //-------------------Retrouver l'employé correspondant à un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employe> getEmploye(@PathVariable(value = "id") int id)  throws Exception{
        System.out.println("recherche de l'employé d' id " + id);
        Employe employe = employeServiceImpl.read(id);
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }
    //-------------------Retrouver les clients portant un nom donné--------------------------------------------------------
    @RequestMapping(value = "/nom={nom}", method = RequestMethod.GET)
    public ResponseEntity<List<Employe>> listEmployesNom(@PathVariable(value="nom") String nom) throws Exception{
        System.out.println("recherche de "+nom);
        List<Employe> employe;
        employe = employeServiceImpl.read(nom);
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }
    //-------------------Retrouver l'employé correspondant à un triplet--------------------------------------------------------
    @RequestMapping(value = "/{matricule}/{nom}/{prenom}", method = RequestMethod.GET)
    public ResponseEntity<Employe> getEmployeUnique(@PathVariable(value = "matricule") String matricule, @PathVariable(value = "nom") String nom,@PathVariable(value = "prenom") String prenom)  throws Exception{
        System.out.println("recherche de l'employé  "+matricule+" "+nom+" "+prenom);
        Employe employe = employeServiceImpl.read(matricule,nom,prenom);
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }
    //-------------------Retrouver tous les employés --------------------------------------------------------
    @RequestMapping(value = "/all"
            ,method = RequestMethod.GET)
    public ResponseEntity<List<Employe>> listEmployes() throws Exception{
        System.out.println
                ("recherche de tous les employés");
        return new ResponseEntity<>(employeServiceImpl.all(), HttpStatus.OK);
    }

    //-------------------Créer un employé--------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) throws Exception {
        System.out.println("Création de l'employé " + employe.getNom());
        employeServiceImpl.create(employe);
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }

    //-------------------Mettre à jour un employé sur base d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employe> majEmploye(@PathVariable(value = "id") int id,@RequestBody Employe nouvemp) throws Exception{
        System.out.println("maj de l'employé id =  " + id);
        nouvemp.setIdemploye(id);
        Employe xxx = employeServiceImpl.update(nouvemp);
        return new ResponseEntity<>(xxx, HttpStatus.OK);
    }

    //-------------------Effacer un employé d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEmploye(@PathVariable(value = "id") int id) throws Exception{
        System.out.println("effacement de l'employé d'id " + id);
        Employe employe = employeServiceImpl.read(id);
        employeServiceImpl.delete(employe);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //-------------------Gérer les erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void>  handleIOException(Exception ex) {
        System.out.println("erreur : "+ex.getMessage());
        return ResponseEntity.notFound().header("error",ex.getMessage()).build();
    }

}


