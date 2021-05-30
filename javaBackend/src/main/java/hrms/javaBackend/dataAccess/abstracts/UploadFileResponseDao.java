package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.core.File.concretes.UploadFileResponse;

public interface UploadFileResponseDao extends JpaRepository<UploadFileResponse, Integer> {

}
