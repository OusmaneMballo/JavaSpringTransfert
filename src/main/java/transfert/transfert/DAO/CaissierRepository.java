package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Caissier;
import transfert.transfert.Model.Compte;
import transfert.transfert.Model.Operation;

import java.util.List;

@Repository
public interface CaissierRepository extends JpaRepository<Caissier, Integer> {
    public Caissier findById(int id);
    public Caissier findCaissierByCode(String code);
    public List<Operation> findCaissierByOperations(Caissier c);
    public List<Compte> findByComptes(Caissier c);
}
