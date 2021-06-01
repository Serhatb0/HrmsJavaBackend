package hrms.javaBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.ViewCvService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.ViewCvDao;
import hrms.javaBackend.entities.concretes.JobPostings;
import hrms.javaBackend.entities.concretes.ViewCv;
import net.bytebuddy.asm.Advice.This;

@Service
public class ViewCvManager  implements ViewCvService{

	private ViewCvDao viewCvDao;
	
	@Autowired
	public ViewCvManager(ViewCvDao viewCvDao) {
		super();
		this.viewCvDao = viewCvDao;
	}


	@Override
	public DataResult<List<ViewCv>> getAll() {
		return new SuccessDataResult<List<ViewCv>>(this.viewCvDao.findAll(),"Cv Görntülendi");
	}


	@Override
	public Result add(ViewCv viewCv) {
		this.viewCvDao.save(viewCv);
		return new SuccessResult("Cv Kaydedildi");
	}


	@Override
	public DataResult<List<ViewCv>> getAllByeducation_schoolStatus() {
		return new SuccessDataResult<List<ViewCv>>(this.viewCvDao.getAllByeducation_schoolStatusTrue(),"Data Listelendi");
	}


	@Override
	public DataResult<List<ViewCv>> getAllByworkExperience_operationTimeGreaterThan(int number) {
		return new SuccessDataResult<List<ViewCv>>(this.viewCvDao.getAllByworkExperience_operationTimeGreaterThanEqual(number),"Data Listelendi");
	}


	@Override
	public DataResult<List<ViewCv>> getAllByworkExperience_workingStatusTrue() {
		return new SuccessDataResult<List<ViewCv>>(this.viewCvDao.getAllByworkExperience_workingStatusTrue(),"Aktif Çalışanlar Listelendi");
	}


	@Override
	public DataResult<List<ViewCv>> getAllByworkExperience_workingStatusFalse() {
		return new SuccessDataResult<List<ViewCv>>(this.viewCvDao.getAllByworkExperience_workingStatusFalse(),"Çalışmayanlar Listelendi");
	}

}
