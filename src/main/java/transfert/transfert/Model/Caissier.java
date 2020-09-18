package transfert.transfert.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("C")
public class Caissier extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    private String code;
    @Column(length = 10)
    private String numContrat;
    @Column(length = 100)
    private String photo;
    @OneToMany(mappedBy = "caissier")
    private List<Operation> operations;
    @OneToMany(mappedBy = "caissier")
    private List<Compte> comptes;

    public Caissier(){

    }

    public Caissier(String nom, String prenom, String telephone, String nci, String code, String numContrat, String photo) {
        super(nom, prenom, telephone, nci);
        this.code = code;
        this.numContrat = numContrat;
        this.photo = photo;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumContrat() {
        return numContrat;
    }

    public void setNumContrat(String numContrat) {
        this.numContrat = numContrat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
