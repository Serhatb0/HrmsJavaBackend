package hrms.javaBackend.core.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {
	
	private String cloudName = "dmeviw9q7";
	private String apiKey = "687677614368629";
	private String apiSecret = "GHDwcBeEutUh5raKRpbgM6KsEzI";
	
	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = null;
		Map<String ,String> config = new HashMap<>();
		config.put("cloud_name", cloudName);
		config.put("api_key", apiKey);
		config.put("api_secret", apiSecret);
		cloudinary = new Cloudinary(config);
		return cloudinary;
	}
	
	
	@Autowired
	private Cloudinary cloudinaryConfig;
	

	public String uploadFile(MultipartFile file) {
		try {
			File uploadedFile = convertMultiPartToFile(file);
			Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, ObjectUtils.emptyMap());
			return uploadResult.get("url").toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	
	
	public Map delete (String id) throws IOException {
		Map result = cloudinaryConfig.uploader().destroy(id,ObjectUtils.emptyMap());
		return result;
	}

}