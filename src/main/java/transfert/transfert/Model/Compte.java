package transfert.transfert.Model;

public class Compte {

    private int id;
    private String numero;
    private String date_crea;
    private float montant;
    private Personne client;
    private Personne caissier;

    public Compte() {
    }

    public Compte(String numero, String date_crea, float montant, Personne client, Personne caissier) {
        this.numero = numero;
        this.date_crea = date_crea;
        this.montant = montant;
        this.client = client;
        this.caissier = caissier;
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDate_crea() {
        return date_crea;
    }

    public void setDate_crea(String date_crea) {
        this.date_crea = date_crea;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Personne getClient() {
        return client;
    }

    public void setClient(Personne client) {
        this.client = client;
    }

    public Personne getCaissier() {
        return caissier;
    }

    public void setCaissier(Personne caissier) {
        this.caissier = caissier;
    }
}
