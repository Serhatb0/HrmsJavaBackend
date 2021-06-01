package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.dataAccess.abstracts.CandidateCvDao;
import hrms.javaBackend.entities.concretes.CandidateCv;

public interface CandidateCvService {

	DataResult<List<CandidateCv>> getAll();
	
	Result add(CandidateCv candidateCv);
	
}
