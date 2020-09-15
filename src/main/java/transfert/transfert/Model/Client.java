package transfert.transfert.Model;

public class Client extends Personne {

    private int id;
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
