package be.condorcet.thymeleafloganfrancois.services;

import be.condorcet.thymeleafloganfrancois.entities.Employe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeServiceImplTest {

    @Autowired
    private InterfEmployeService empServiceImpl;

    Employe emp;

    @BeforeEach
    void setUp() {
        try {
            emp = new Employe(null, "MatTest", "NTest", "PTest", "TTest", "t@test.be",null);
            empServiceImpl.create(emp);
            System.out.println("création de l'employé : " + emp);
        } catch (Exception e) {
            System.out.println("erreur de création de l'employé : " + emp + " erreur : " + e);
        }
    }


    @AfterEach
    void tearDown() {
        try {
            empServiceImpl.delete(emp);
            System.out.println("effacement de l'employé: " + emp);
        } catch (Exception e) {
            System.out.println("erreur d'effacement de l'employé :" + emp + " erreur : " + e);
        }
    }

    @Test
    void create() {
        assertNotEquals(0, emp.getIdemploye(), "id employé non incrémenté");
        assertEquals("MatTest", emp.getMatricule(), "matricule employé non enregistré : " + emp.getMatricule() + " au lieu de MatriculeTest");
        assertEquals("NTest", emp.getNom(), "nom employé non enregistré : " + emp.getNom() + " au lieu de NomTest");
        assertEquals("PTest", emp.getPrenom(), "prénom employé non enregistré : " + emp.getPrenom() + " au lieu de PrenomTest");
        assertEquals("TTest", emp.getTel(), "tel employé non enregistré : " + emp.getTel() + " au lieu de TelTest");
        assertEquals("t@test.be", emp.getMail(), "mail employé non enregistré : " + emp.getMail() + " au lieu de test@test.be");
        System.out.println("ok");
    }



   @Test
    void read() {
        try{
            int numEmp = emp.getIdemploye();
            Employe emp2= empServiceImpl.read(numEmp);
            assertEquals("MatTest",emp2.getMatricule(),"Matricules différents "+"NTest"+"-"+emp2.getMatricule());
            assertEquals("NTest",emp2.getNom(),"Noms différents "+"NTest"+"-"+emp2.getNom());
            assertEquals("PTest",emp2.getPrenom(),"Prénoms différents "+"PTest"+"-"+emp2.getPrenom());
            System.out.println("ok");

        }
        catch (Exception e){
            fail(" ça marche po "+e);
        }
    }

    @Test
    void update() {
        try{
            emp.setMatricule("MatriculeTest2");
            emp.setNom("NomTest2");
            emp.setPrenom("PrenomTest2");
            //etc
            emp = empServiceImpl.update(emp);
            assertEquals("MatriculeTest2",emp.getMatricule(),"prénoms différents "+"PrenomTest2-"+emp.getMatricule());
            assertEquals("NomTest2",emp.getNom(),"noms différents "+"NomTest2-"+emp.getNom());
            assertEquals("PrenomTest2",emp.getPrenom(),"prénoms différents "+"PrenomTest2-"+emp.getPrenom());

        }
        catch(Exception e){
            fail("erreur de mise à jour "+e);
        }
    }
    @Test
    void delete() {
        try{
            empServiceImpl.delete(emp);    Assertions.assertThrows(Exception.class, () -> {empServiceImpl.read(emp.getIdemploye());},"record non effacé");
        }
        catch(Exception e){
            fail("erreur d'effacement "+e);
        }
    }


    // delete projet

    @Test
    void rechNom() {
        List<Employe> le = empServiceImpl.read("NTest");
        boolean trouve=false;
        for(Employe e : le){
            if(e.getNom().equals("NTest"))  trouve=true;
            else fail("un record ne correspond pas , nom = "+e.getNom());
        }
        assertTrue(trouve,"record non trouvé dans la liste");
    }

    @Test
    void all(){
        try {
            List<Employe> le = empServiceImpl.all();
            assertNotEquals(0,le.size(),"la liste ne contient aucun élément");
        }catch (Exception e){
            fail("erreur de recherche de tous les clients "+e);
        }
    }
}




