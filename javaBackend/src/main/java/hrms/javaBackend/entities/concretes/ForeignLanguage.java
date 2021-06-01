package hrms.javaBackend.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","viewCvs"})
public class ForeignLanguage {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="foreign_languages_id")
	private int foreignLanguagesId;
	

	@Column(name="language_name")
	private String languageName;
	
	@Column(name="language_level")
	private int languageLevel;
	

	
	@OneToMany(mappedBy = "foreignLanguage")
	private List<ViewCv> viewCvs;
	
}
