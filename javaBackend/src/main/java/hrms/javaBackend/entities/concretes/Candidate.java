package hrms.javaBackend.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.javaBackend.core.entities.UploadFileResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "candidates")
public class Candidate extends User {
	
	@NotBlank
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@NotNull
	@Column(name = "identity_number")
	private String identityNumber;

	@NotBlank
	@NotNull
	@Column(name = "birth_date")
	private LocalDate birthDate;




	@OneToMany(mappedBy = "candidate")
	private List<Photo> photos;

	@OneToMany(mappedBy = "candidate")
	private List<CandidateCv> candidateCvs;
	
	@OneToMany(mappedBy = "candidate")
	private List<CandidatesDetail> candidatesDetails;
	
	@OneToMany(mappedBy = "candidate")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "candidate")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(mappedBy = "candidate")
	private List<SocialMedia> socialMedias;
	
	@OneToMany(mappedBy = "candidate")
	private List<WorkExperience> workExperiences;

}
