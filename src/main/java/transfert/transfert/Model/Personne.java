package transfert.transfert.Model;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="personne_type")
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nom;
    @Column(length = 30)
    private String prenom;
    @Column(length = 15)
    private String telephone;
    @Column(length = 30, unique = true, nullable = false)
    private String nci;

    public Personne() {
    }

    public Personne(String nom, String prenom, String telephone, String nci) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.nci = nci;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }
}
