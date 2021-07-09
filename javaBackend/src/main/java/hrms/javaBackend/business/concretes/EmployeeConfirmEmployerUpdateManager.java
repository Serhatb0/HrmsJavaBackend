package hrms.javaBackend.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EmployeeConfirmEmployerUpdateService;
import hrms.javaBackend.business.abstracts.EmployeeService;
import hrms.javaBackend.business.abstracts.EmployerService;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EmployeeConfirmEmployerUpdateDao;
import hrms.javaBackend.entities.concretes.Employee;
import hrms.javaBackend.entities.concretes.EmployeeConfirmEmployerUpdate;
import hrms.javaBackend.entities.concretes.Employer;

@Service
public class EmployeeConfirmEmployerUpdateManager implements EmployeeConfirmEmployerUpdateService {

	EmployeeConfirmEmployerUpdateDao employeeConfirmEmployerUpdateDao;
	EmployerService employerService;
	EmployeeService employeeService;

	@Autowired
	public EmployeeConfirmEmployerUpdateManager(EmployeeConfirmEmployerUpdateDao employeeConfirmEmployerUpdateDao,
			EmployerService employerService, EmployeeService employeeService) {
		super();
		this.employeeConfirmEmployerUpdateDao = employeeConfirmEmployerUpdateDao;
		this.employerService = employerService;
		this.employeeService = employeeService;
	}

	@Override
	public Result activeUpdateEmployer(int employerId, EmployeeConfirmEmployerUpdate employeeConfirmEmployerUpdate,
			int employeeId) {
		Employee employee = this.employeeService.getAllById(employeeId).getData();
		Employer employer = this.employerService.findById(employerId).getData();

		employer.setIsUpdate(true);
		employeeConfirmEmployerUpdate.setEmployee(employee);
		employeeConfirmEmployerUpdate.setEmployer(employer);
		employeeConfirmEmployerUpdate.setCreatedDate(new Date());
		employeeConfirmEmployerUpdate.setIsConfirmed(true);
		this.employeeConfirmEmployerUpdateDao.save(employeeConfirmEmployerUpdate);
		return new SuccessResult("İş Veren Güncellemesi Kabul Edildi");

	}

	@Override
	public Result rejectUpdateEmployer(int employerId, EmployeeConfirmEmployerUpdate employeeConfirmEmployerUpdate,
			int employeeId) {
		Employee employee = this.employeeService.getAllById(employeeId).getData();
		Employer employer = this.employerService.findById(employerId).getData();

		employer.setIsUpdate(false);
		employeeConfirmEmployerUpdate.setEmployee(employee);
		employeeConfirmEmployerUpdate.setEmployer(employer);
		employeeConfirmEmployerUpdate.setCreatedDate(new Date());
		employeeConfirmEmployerUpdate.setIsConfirmed(false);
		this.employeeConfirmEmployerUpdateDao.save(employeeConfirmEmployerUpdate);
		return new SuccessResult("İş Veren Güncellemesi Kabul Edildi");
	}

}
