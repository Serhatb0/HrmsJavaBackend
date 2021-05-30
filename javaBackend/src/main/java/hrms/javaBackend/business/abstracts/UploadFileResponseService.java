package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.File.concretes.UploadFileResponse;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

public interface UploadFileResponseService {
	
	Result add(UploadFileResponse uploadFileResponse);
	
	DataResult<List<UploadFileResponse>> getAll();

}
