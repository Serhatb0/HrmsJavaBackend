package hrms.javaBackend.entities.dtos.ViewDtos;

import java.io.Serializable;
import java.time.LocalDate;

import hrms.javaBackend.entities.concretes.Education;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationViewDto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String schoolName;

	private String episode;

	private LocalDate startOfSchool;

	private LocalDate graduationYear;

	private Boolean schoolStatus;
	
	public static EducationViewDto of(Education education) {
		
		return new EducationViewDto(education.getSchoolName(),education.getEpisode()
				,education.getStartOfSchool(),education.getGraduationYear(),education.getSchoolStatus()
				);
		
		
	}
	
	
	
}
