package be.condorcet.thymeleafloganfrancois.entities;

import lombok.*;
import javax.management.ConstructorParameters;
import javax.persistence.*;
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



}
