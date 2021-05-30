package hrms.javaBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.UploadFileResponseService;
import hrms.javaBackend.core.File.concretes.UploadFileResponse;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.UploadFileResponseDao;

@Service
public class UploadFileResponseManager implements UploadFileResponseService {

	private UploadFileResponseDao uploadFileResponseDao;
	
	
	
	@Autowired
	public UploadFileResponseManager(UploadFileResponseDao uploadFileResponseDao) {
		super();
		this.uploadFileResponseDao = uploadFileResponseDao;
	}




	@Override
	public Result add(UploadFileResponse uploadFileResponse) {
		this.uploadFileResponseDao.save(uploadFileResponse);
		return new SuccessResult("Belge Başarıyla Eklendi");
	}




	@Override
	public DataResult<List<UploadFileResponse>> getAll() {
		return new SuccessDataResult<List<UploadFileResponse>>(this.uploadFileResponseDao.findAll());
	}

}
