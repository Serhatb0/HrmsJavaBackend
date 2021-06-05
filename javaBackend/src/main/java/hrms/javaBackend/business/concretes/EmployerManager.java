package hrms.javaBackend.business.concretes;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.Helpers.abstracts.EmployerApprovalService;
import hrms.javaBackend.business.Helpers.abstracts.EmployerUserCheckHelperService;
import hrms.javaBackend.business.abstracts.EmailServiceBusiness;
import hrms.javaBackend.business.abstracts.EmployerService;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EmployerDao;
import hrms.javaBackend.entities.concretes.Employer;
import hrms.javaBackend.entities.dtos.RegisterForEmployerDto;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerUserCheckHelperService employerUserCheckHelperService;
	private EmployerApprovalService employerApprovalService;
	private ModelMapper modelMapper;
	private EmailServiceBusiness emailServiceBusiness;

	@Autowired	
	public EmployerManager(EmployerDao employerDao, EmployerUserCheckHelperService employerUserCheckHelperService,
			EmployerApprovalService employerApprovalService, ModelMapper modelMapper, EmailServiceBusiness emailServiceBusiness) {
		super();
		this.employerDao = employerDao;
		this.employerUserCheckHelperService = employerUserCheckHelperService;
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
	public Result addRegister(RegisterForEmployerDto registerForEmployerDto) {
		Employer employer = modelMapper.map(registerForEmployerDto, Employer.class);

		employer.setStaffApproval(null);

		boolean checkEmail = this.findByEmailIs(employer.getEmail()).getData().size() != 0;
//		boolean requiredField = !this.employerUserCheckHelperService.allFieldsAreRequired(employer);
		boolean EmployeeConfrim = !this.employerApprovalService.confirmEmployer(employer);

		if (checkEmail || EmployeeConfrim ) {

			String errorMessage = "";

			if (checkEmail) {
				errorMessage = "Bu Email Zaten Mevcut";
			}
			if (EmployeeConfrim) {
				errorMessage = "Kayıt İşleminiz Reddedildi";
			}
			

			return new ErrorResult(errorMessage);
		}
		modelMapper.map(this.employerDao.save(employer), RegisterForEmployerDto.class);
		return new SuccessResult(emailServiceBusiness.sendEmail(employer,registerForEmployerDto.getEmail()).getMessage());

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

}
