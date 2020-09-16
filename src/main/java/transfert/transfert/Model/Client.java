package transfert.transfert.Model;

import javax.persistence.*;

@Entity
public class Client extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "client")
    private Compte compte;

    public Client() {
    }

    public Client(Compte compte) {
        this.compte = compte;
    }

    public Client(String nom, String prenom, String telephone, String nci, Compte compte) {
        super(nom, prenom, telephone, nci);
        this.compte = compte;
    }

    @Override
    public int getId() {
        return id;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
