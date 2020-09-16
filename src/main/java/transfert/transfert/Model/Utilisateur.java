package transfert.transfert.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import transfert.transfert.Model.Caissier;

@Entity
public class Utilisateur{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nom;
    @Column(length = 30)
    private String prenom;
    @Column(length = 15)
    private String telephone;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String telephone, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
