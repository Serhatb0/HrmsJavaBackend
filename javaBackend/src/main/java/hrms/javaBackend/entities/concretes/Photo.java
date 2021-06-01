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
	
	@ManyToOne()
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
	

}
