package hrms.javaBackend.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hrms.javaBackend.entities.concretes.Candidate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "upload_file_response")
public class UploadFileResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_download_uri")
	private String fileDownloadUri;
	
	@Column(name = "file_type")
	private String fileType;
	
	@Column(name = "size")
	private long size;
	
	//@Column(name="candidate_id")
	//private int candidateId;
	
	

	
}