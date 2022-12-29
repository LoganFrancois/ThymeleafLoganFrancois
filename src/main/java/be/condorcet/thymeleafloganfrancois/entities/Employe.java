package be.condorcet.thymeleafloganfrancois.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "API_EMPLOYE", schema = "ORA44", catalog = "orcl")
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employe_generator")
    @SequenceGenerator(name="employe_generator", sequenceName = "API_EMPLOYE_SEQ", allocationSize=1)
    private Integer idemploye;
    @NonNull
    private String matricule;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private String tel;
    @NonNull
    private String mail;
    @JsonIgnore
    @OneToMany(mappedBy = "employe" , fetch = FetchType.LAZY) //-> pour éviter de supprimer un employé et un projet en même temps
    @ToString.Exclude
    private List <Projet> projets;
}
