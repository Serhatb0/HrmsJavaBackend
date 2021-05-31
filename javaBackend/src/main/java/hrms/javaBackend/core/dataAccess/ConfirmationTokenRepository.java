package hrms.javaBackend.core.dataAccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hrms.javaBackend.core.entities.ConfirmationToken;

@Repository("confirmationTokenRepository")
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}