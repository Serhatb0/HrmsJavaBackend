package hrms.javaBackend.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.Helpers.abstracts.EmployerApprovalService;
import hrms.javaBackend.business.abstracts.EmailServiceBusiness;
import hrms.javaBackend.business.abstracts.EmployerService;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EmployerDao;
import hrms.javaBackend.entities.concretes.Employer;
import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForEmployerCreateDto;


@Service

public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	private EmployerApprovalService employerApprovalService;
	
	private ModelMapper modelMapper;
	private EmailServiceBusiness emailServiceBusiness;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerApprovalService employerApprovalService,
			ModelMapper modelMapper, EmailServiceBusiness emailServiceBusiness) {
		super();
		this.employerDao = employerDao;
		this.employerApprovalService = employerApprovalService;
		this.modelMapper = modelMapper;
		this.emailServiceBusiness = emailServiceBusiness;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Empoloyer Listelendi");
	}

	@Override
	public DataResult<List<Employer>> findByEmailIs(String email) {
		return new SuccessDataResult<>(this.employerDao.findByEmailIs(email));
	}

	@Override
	public Result addRegister(RegisterForEmployerCreateDto registerForEmployerDto) {
		Employer employer = modelMapper.map(registerForEmployerDto, Employer.class);

		employer.setStaffApproval(null);

		boolean EmployeeConfrim = !this.employerApprovalService.confirmEmployer(employer);

		if (EmployeeConfrim) {

			String errorMessage = "";

			if (EmployeeConfrim) {
				errorMessage = "Kayıt İşleminiz Reddedildi";
			}

			return new ErrorResult(errorMessage);
		}
		modelMapper.map(this.employerDao.save(employer), RegisterForEmployerCreateDto.class);
		return new SuccessResult(
				emailServiceBusiness.sendEmail(employer, registerForEmployerDto.getEmail()).getMessage());

	}

	@Override
	public DataResult<List<Employer>> findBystaffApprovalIsNull() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findBystaffApprovalIsNull());
	}

	@Override
	public DataResult<List<Employer>> findBystaffApprovalFalse() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findBystaffApprovalFalse());
	}

	@Override
	public DataResult<List<Employer>> findBystaffApprovalTrue() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findBystaffApprovalTrue());
	}

	@Override
	public DataResult<Employer> findBycompanyName(String companyName) {
		return new SuccessDataResult<Employer>(this.employerDao.findBycompanyName(companyName));

	}

	@Override
	public Result updateEmployer(int id, String companyName, String webAddress, String email) {
		Employer employer = this.employerDao.findById(id);

		employer.setIsUpdate(false);
		this.employerDao.updateEmployer(id, companyName, webAddress, email);
		return new SuccessResult("Başarıyla Güncellendi");
	}

	@Override
	public DataResult<Employer> findById(int employerId) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(employerId));

	}

}
