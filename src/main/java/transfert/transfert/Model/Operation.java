package transfert.transfert.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private String type;
    @Column(nullable = false)
    private float montant;
    @Column(length = 12)
    private String date;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "caissier_id")
    private Caissier caissier;

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

    public Caissier getCaissier() {
        return caissier;
    }

    public void setCaissier(Caissier caissier) {
        this.caissier = caissier;
    }
}
