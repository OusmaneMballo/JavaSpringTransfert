package transfert.transfert.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 15)
    private String numero;
    @Column(length = 25)
    private String date_crea;
    @Column(nullable = false)
    private float montant;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Personne client;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "caissier_id")
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
