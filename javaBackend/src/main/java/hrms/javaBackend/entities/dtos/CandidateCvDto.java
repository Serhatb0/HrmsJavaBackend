package hrms.javaBackend.entities.dtos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvDto {


	private String workplaceName;

	private String jobPosition;

	private LocalDate jobStartDate;

	private LocalDate jobEndDate;

	private Boolean workingStatus;

	private int operationTime;
	
	private String githubAddress;

	private String linkedinAddress;
	
	private String languageName;
	
	private int languageLevel;
	
	private String schoolName;
	
	private String episode;
	
	private LocalDate startOfSchool;
	
	private LocalDate  graduationYear;
	
	private Boolean schoolStatus;
	
	private String technologyNames;
	
	private String coverLetter;
	

	
}
