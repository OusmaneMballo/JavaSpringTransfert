package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Caissier;
import transfert.transfert.Model.Client;
import transfert.transfert.Model.Compte;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    public List<Compte> findAll();
    public List<Compte> findByCaissier(Caissier caissier);
    public Compte findByClient(Client client);
    public Compte findById(int id);

}
