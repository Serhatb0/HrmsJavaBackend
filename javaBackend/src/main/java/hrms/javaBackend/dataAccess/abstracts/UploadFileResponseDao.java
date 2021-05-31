package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.core.entities.UploadFileResponse;

public interface UploadFileResponseDao extends JpaRepository<UploadFileResponse, Integer> {

}
