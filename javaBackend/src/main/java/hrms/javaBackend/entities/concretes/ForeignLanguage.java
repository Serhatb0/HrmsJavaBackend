package hrms.javaBackend.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foreign_languages")
public class ForeignLanguage {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="foreign_languages_id")
	private int foreignLanguagesId;
	
//	@Column(name="candidate_id")
//	private int candidateId;
	
	@Column(name="language_name")
	private String languageName;
	
	@Column(name="language_level")
	private int languageLevel;
	
	@ManyToOne()
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
	
}
