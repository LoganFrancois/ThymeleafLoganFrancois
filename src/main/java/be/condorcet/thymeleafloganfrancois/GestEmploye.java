package be.condorcet.thymeleafloganfrancois;

import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.repositories.EmployeRepository;
import be.condorcet.thymeleafloganfrancois.services.EmployeServiceImpl;
import be.condorcet.thymeleafloganfrancois.services.InterfEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/employes")
public class GestEmploye {

    //@Autowired
   //private EmployeServiceImpl employeServiceimpl;

   @Autowired
    private InterfEmployeService employeServiceimpl;
    @RequestMapping("/tous")
    public String affTous(Map<String, Object> model) {
        System.out.println("recherche employes");
        try {
            Collection<Employe> lem = employeServiceimpl.all();
            model.put("mesEmployes", lem);
        } catch (Exception e) {
            System.out.println("----------erreur lors de la recherche------ -- " + e);
            model.put("error", e.getMessage());
            return "error";
        }
        return "affichagetousEmployes";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String matricule, @RequestParam String nom, @RequestParam String prenom, @RequestParam String tel, @RequestParam String mail, Map<String, Object> model) {
        System.out.println("Ajout d'un employé");
      Employe emp = new Employe(matricule, nom, prenom,tel,mail);
        try {
            employeServiceimpl.create(emp);
            System.out.println(emp);
          /* emp = employeServiceimpl.read(emp.getIdemploye());
            emp.setMatricule("KC30");
            emp.setMail("philou@gmail.com");
            employeServiceimpl.update(emp); */
            model.put("nouvemp", emp);
        } catch (Exception e) {
            System.out.println("----------erreur lors de la création------- - " + e);
            model.put("error", e.getMessage());
            return "error";
        }
        return "nouvelEmploye";
    }

    @RequestMapping("/readId")
    public String read(@RequestParam int idemploye, Map<String, Object> model){
        System.out.println("recherche du client n° "+idemploye);
        try {
            Employe emp = employeServiceimpl.read(idemploye);
            model.put("monEmp",emp);
        }catch (Exception e) {
            System.out.println("----------erreur lors de la recherche ----- --- " + e);
            model.put("error",e.getMessage());
            return "error";
        }
        return "monEmploye";
    }
    @RequestMapping("delete")
    public String delete(@RequestParam int idemploye, Map<String, Object> model) {
        Employe emp = new Employe();
        System.out.println("suppression du client");
        emp.setIdemploye(idemploye);
        try {
            employeServiceimpl.delete(emp);
            model.put("mesEmployes", emp);

        }catch (Exception e) {
            System.out.println("----------erreur lors de la suppression ----- --- " + e);
            model.put("error",e.getMessage());
            return "error";
        }
        return "validationSuppression";
   }


    @RequestMapping("update")
    public String update(@RequestParam String matricule, @RequestParam int idemploye, Map<String, Object> model) {
       Employe emp = new Employe();
        System.out.println("mise à jour du client");
        emp.setIdemploye(idemploye);
        try {
            emp = employeServiceimpl.read(emp.getIdemploye());
            emp.setMatricule(matricule);
            employeServiceimpl.update(emp);
            model.put("nouvemp", emp);

        }catch (Exception e) {
            System.out.println("----------erreur lors de la suppression ----- --- " + e);
            model.put("error",e.getMessage());
            return "error";
        }
        return "modifEmploye";
    }

    @RequestMapping("/readNom")
    public String read(@RequestParam String nom, Map<String, Object> model){
        System.out.println("Voici tous les employés qui portent le nom "+nom);
        List<Employe> lemp = new ArrayList<>();

        try {
            lemp = employeServiceimpl.read(nom);
            model.put("mesEmployes",lemp);
        }catch (Exception e) {
            System.out.println("----------erreur lors de la recherche ----- --- " + e);
            model.put("error",e.getMessage());
            return "error";
        }
        return "mesEmployes";
    }




}




