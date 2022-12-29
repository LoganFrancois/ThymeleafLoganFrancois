package be.condorcet.thymeleafloganfrancois.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "API_PROJET", schema = "ORA44", catalog = "orcl")
public class Projet {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projet_generator")
    @SequenceGenerator(name="projet_generator", sequenceName = "API_PROJET_SEQ", allocationSize=1)
    private Integer idprojet;
    @NonNull
    private String nomproj;
    @NonNull
    private Date datedebut;

    private Date datefin;

    private BigDecimal cout;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IDRESPONSABLE")
    private Employe employe;





}
