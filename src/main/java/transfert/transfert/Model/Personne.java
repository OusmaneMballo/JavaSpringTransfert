package transfert.transfert.Model;

public abstract class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
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
