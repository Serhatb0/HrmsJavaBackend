package hrms.javaBackend.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EmployeeConfirmsEmployerService;
import hrms.javaBackend.business.abstracts.EmployerService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EmployeeConfirmsEmployerDao;
import hrms.javaBackend.entities.concretes.EmployeeConfirmsEmployer;
import hrms.javaBackend.entities.concretes.Employer;

@Service
public class EmployeeConfirmsEmployerManager implements EmployeeConfirmsEmployerService {

	private EmployeeConfirmsEmployerDao employeeConfirmsEmployerDao;
	private EmployerService employerService;

	@Autowired
	public EmployeeConfirmsEmployerManager(EmployeeConfirmsEmployerDao employeeConfirmsEmployerDao,
			EmployerService employerService) {
		super();
		this.employeeConfirmsEmployerDao = employeeConfirmsEmployerDao;
		this.employerService = employerService;
	}

	@Override
	public DataResult<List<EmployeeConfirmsEmployer>> getAll() {
		return new SuccessDataResult<List<EmployeeConfirmsEmployer>>(this.employeeConfirmsEmployerDao.findAll(),
				"Data Listelendi");
	}

	@Override
	public DataResult<EmployeeConfirmsEmployer> findByemployer_companyName(String companyName) {
		return new SuccessDataResult<EmployeeConfirmsEmployer>(
				this.employeeConfirmsEmployerDao.findByemployer_companyName(companyName));
	}

	@Override
	public Result activeEmployer(String companyName, EmployeeConfirmsEmployer employeeConfirmsEmployer) {
		Employer employer = this.employerService.findBycompanyName(companyName).getData();

		employer.setStaffApproval(true);
		employeeConfirmsEmployer.setIsConfirmed(true);
		employeeConfirmsEmployer.setCreatedDate(new Date());
		this.employeeConfirmsEmployerDao.save(employeeConfirmsEmployer);
		return new SuccessResult("İş Veren Aktif Edildi");

	}

	@Override
	public Result rejectEmployer(String companyName, EmployeeConfirmsEmployer employeeConfirmsEmployer) {
		Employer employer = this.employerService.findBycompanyName(companyName).getData();

		employer.setStaffApproval(false);
		employeeConfirmsEmployer.setIsConfirmed(false);
		employeeConfirmsEmployer.setCreatedDate(new Date());
		this.employeeConfirmsEmployerDao.save(employeeConfirmsEmployer);
		return new SuccessResult("İş Veren Reddedildi");
	}

}
