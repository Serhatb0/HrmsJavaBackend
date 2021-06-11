package hrms.javaBackend.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EmployeeConfirmJobPostingService;
import hrms.javaBackend.business.abstracts.EmployeeService;
import hrms.javaBackend.business.abstracts.JobPositionService;
import hrms.javaBackend.business.abstracts.JobPostingsService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EmployeeConfirmJobPostingDao;
import hrms.javaBackend.entities.concretes.Employee;
import hrms.javaBackend.entities.concretes.EmployeeConfirmJobPosting;
import hrms.javaBackend.entities.concretes.JobPostings;

@Service
public class EmployeeConfirmJobPostingManager implements EmployeeConfirmJobPostingService {

	private EmployeeConfirmJobPostingDao employeeConfirmJobPostingDao;
	private JobPostingsService jobPostingsService;
	private EmployeeService employeeService;

	@Autowired
	public EmployeeConfirmJobPostingManager(EmployeeConfirmJobPostingDao employeeConfirmJobPostingDao,
			JobPostingsService jobPostingsService, EmployeeService employeeService) {
		super();
		this.employeeConfirmJobPostingDao = employeeConfirmJobPostingDao;
		this.jobPostingsService = jobPostingsService;
		this.employeeService = employeeService;
	}

	@Override
	public DataResult<List<EmployeeConfirmJobPosting>> getAll() {
		return new SuccessDataResult<List<EmployeeConfirmJobPosting>>(this.employeeConfirmJobPostingDao.findAll());
	}

	@Override
	public Result activeJobPosting(int jobPostingsId, EmployeeConfirmJobPosting employeeConfirmJobPosting,
			int employeeId) {
		JobPostings jobPostings = this.jobPostingsService.getAllByjobPostingsId(jobPostingsId).getData();

		Employee employee = this.employeeService.getAllById(employeeId).getData();
		jobPostings.setIsActive(true);
		employeeConfirmJobPosting.setCreatedDate(new Date());
		employeeConfirmJobPosting.setIsConfirmed(true);
		employeeConfirmJobPosting.setJobPostings(jobPostings);
		employeeConfirmJobPosting.setEmployee(employee);
		this.employeeConfirmJobPostingDao.save(employeeConfirmJobPosting);
		return new SuccessResult("İş İlanı Aktif Edildi");
	}

	@Override
	public Result rejectJobPosting(int jobPostingsId, EmployeeConfirmJobPosting employeeConfirmJobPosting,
			int employeeId) {
		JobPostings jobPostings = this.jobPostingsService.getAllByjobPostingsId(jobPostingsId).getData();
		Employee employee = this.employeeService.getAllById(employeeId).getData();
		jobPostings.setIsActive(false);
		employeeConfirmJobPosting.setCreatedDate(new Date());
		employeeConfirmJobPosting.setIsConfirmed(false);
		employeeConfirmJobPosting.setJobPostings(jobPostings);
		employeeConfirmJobPosting.setEmployee(employee);
		this.employeeConfirmJobPostingDao.save(employeeConfirmJobPosting);
		return new SuccessResult("İş İlanı Reddedildi");
	}

	@Override
	public DataResult<EmployeeConfirmJobPosting> findByjobPostings_jobPostingsId(int jobPostingsId) {
		return new SuccessDataResult<EmployeeConfirmJobPosting>(
				this.employeeConfirmJobPostingDao.findByjobPostings_jobPostingsId(jobPostingsId));
	}

}
