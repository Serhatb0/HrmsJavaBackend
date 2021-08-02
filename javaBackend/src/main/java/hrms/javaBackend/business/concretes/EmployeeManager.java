package hrms.javaBackend.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EmailServiceBusiness;
import hrms.javaBackend.business.abstracts.EmployeeService;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EmployeeDao;
import hrms.javaBackend.entities.concretes.Employee;

import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForEmployeeCreateDto;

@Service
public class EmployeeManager implements EmployeeService{

	EmployeeDao employeeDao;
	private ModelMapper modelMapper;
	private EmailServiceBusiness emailServiceBusiness;
	

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, ModelMapper modelMapper,
			EmailServiceBusiness emailServiceBusiness) {
		super();
		this.employeeDao = employeeDao;
		this.modelMapper = modelMapper;
		this.emailServiceBusiness = emailServiceBusiness;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(),"Employee Listelendi");
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Employee Eklendi");
	}

	@Override
	public DataResult<Employee> getAllById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.getAllById(id));
	}

	@Override
	public Result updateEmployee(int id, String firstName, String lastName, String email) {
		this.employeeDao.updateEmployee(id, firstName, lastName, email);
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result addRegister(RegisterForEmployeeCreateDto registerForEmployeeDto) {
		Employee employee = modelMapper.map(registerForEmployeeDto, Employee.class);
		
		
		modelMapper.map(this.employeeDao.save(employee), RegisterForEmployeeCreateDto.class);
		return new SuccessResult(emailServiceBusiness.sendEmail(employee, registerForEmployeeDto.getEmail()).getMessage());
		
	}

	

}
