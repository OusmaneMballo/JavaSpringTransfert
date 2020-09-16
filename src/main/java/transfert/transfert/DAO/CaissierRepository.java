package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Caissier;
@Repository
public interface CaissierRepository extends JpaRepository<Caissier, Integer> {

}
