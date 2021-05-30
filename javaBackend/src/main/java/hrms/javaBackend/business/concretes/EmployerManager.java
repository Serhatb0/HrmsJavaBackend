package hrms.javaBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.Helpers.abstracts.EmployerApprovalService;
import hrms.javaBackend.business.Helpers.abstracts.EmployerUserCheckHelperService;
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

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerUserCheckHelperService employerUserCheckHelperService,
			EmployerApprovalService employerApprovalService) {
		super();
		this.employerDao = employerDao;
		this.employerUserCheckHelperService = employerUserCheckHelperService;
		this.employerApprovalService = employerApprovalService;
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
	public Result add(Employer employer) {
		boolean checkEmail = this.findByEmailIs(employer.getEmail()).getData().size() != 0;
		boolean requiredField = !this.employerUserCheckHelperService.allFieldsAreRequired(employer);
		boolean EmployeeConfrim = !this.employerApprovalService.confirmEmployer(employer);

		if (checkEmail || requiredField || EmployeeConfrim || requiredField) {

			String errorMessage = "";

			if (checkEmail) {
				errorMessage = "Bu Email Zaten Mevcut";
			}
			if (EmployeeConfrim) {
				errorMessage = "Kayıt İşleminiz Reddedildi";
			}
			if (requiredField) {
				errorMessage = "Tüm Alanları Doldurun";
			}
			return new ErrorResult(errorMessage);
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer Eklendi");

	}

	@Override
	public Result addRegister(RegisterForEmployerDto registerForEmployerDto) {
		Employer employer = new Employer();
		
		employer.setCompanyName(registerForEmployerDto.getCompanyName());
		employer.setEmail(registerForEmployerDto.getEmail());
		employer.setWebAddress(registerForEmployerDto.getWebsite());
		employer.setPassword(registerForEmployerDto.getPassword());
		
		boolean checkEmail = this.findByEmailIs(employer.getEmail()).getData().size() != 0;
		boolean requiredField = !this.employerUserCheckHelperService.allFieldsAreRequired(employer);
		boolean EmployeeConfrim = !this.employerApprovalService.confirmEmployer(employer);

		if (checkEmail || requiredField || EmployeeConfrim || requiredField) {

			String errorMessage = "";

			if (checkEmail) {
				errorMessage = "Bu Email Zaten Mevcut";
			}
			if (EmployeeConfrim) {
				errorMessage = "Kayıt İşleminiz Reddedildi";
			}
			if (requiredField) {
				errorMessage = "Tüm Alanları Doldurun";
			}
			return new ErrorResult(errorMessage);
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer Eklendi");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
