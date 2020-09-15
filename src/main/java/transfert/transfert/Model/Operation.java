package transfert.transfert.Model;

public class Operation {

    private int id;
    private String type;
    private float montant;
    private String date;

    public Operation() {
    }

    public Operation(String type, float montant, String date) {
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
