package be.condorcet.thymeleafloganfrancois.services;

import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;

class ProjetServiceImplTest {

    @Autowired
    private EmployeServiceImpl empServiceImpl;

    Employe emp;
@Autowired
private ProjetServiceImpl projetServiceImpl;

    Projet projet;
    @BeforeEach
    void setUp() {
        try{
           // emp = new Employe(null, "MatTest", "NTest", "PTest", "TTest", "t@test.be",null);
          //  empServiceImpl.create(emp);

            projet = new Projet("test",Date.valueOf(LocalDate.now()));
            projetServiceImpl.create(projet);
            System.out.println("création du projet : "+projet);
        }
        catch (Exception e){
            System.out.println("erreur de création de commande "+e);
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void all() {
    }

    @Test
    void getProjets() {
    }
}