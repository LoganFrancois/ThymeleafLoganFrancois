package be.condorcet.thymeleafloganfrancois.services;


import be.condorcet.thymeleafloganfrancois.entities.Employe;

import java.util.List;

public interface InterfEmployeService extends InterfService<Employe> {
    public List<Employe> read(String nom);

    public Employe read (String matricule, String nom, String prenom);

    public List<Employe> SearchByNom(String nom);

}