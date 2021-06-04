package hrms.javaBackend.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="photos")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="photo_id")
	private int id;
	
//	@Column(name="candidate_id")
//	private int cantidateId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="delete_id")
	private String deleteId;
	
	@Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

	
	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
	

}
