package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.TypesOfWork;

public interface TypesOfWorkDao extends JpaRepository<TypesOfWork, Integer> {

	
	TypesOfWork findAllById(int id);
}
