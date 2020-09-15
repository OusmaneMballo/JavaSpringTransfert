package transfert.transfert.Model;

public class Caissier extends Personne {
    private int id;
    private String code;
    private String numContrat;
    private String photo;

    public Caissier() {
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
}
