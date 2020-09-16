package transfert.transfert.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transfert.transfert.Model.Caissier;
import transfert.transfert.Model.Operation;
@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {

}
