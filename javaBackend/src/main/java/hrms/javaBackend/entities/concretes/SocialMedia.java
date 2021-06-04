package hrms.javaBackend.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "social_medias")

public class SocialMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "social_media_id")
	private int socialMediaId;

	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	
	
	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@JoinColumn(name = "candidate_id" )
	@ManyToOne(fetch = FetchType.LAZY)
	private Candidate candidate;
}
