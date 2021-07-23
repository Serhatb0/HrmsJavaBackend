package hrms.javaBackend.api.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hrms.javaBackend.business.abstracts.UploadFileResponseService;
import hrms.javaBackend.core.entities.UploadFileResponse;
import hrms.javaBackend.core.utilities.fileHelper.FileStorageService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import java.util.List;


@RestController
@RequestMapping("/api/Files")
public class FileController {

	private UploadFileResponseService uploadFileResponseService;
	
	@Autowired
    public FileController(UploadFileResponseService uploadFileResponseService) {
		super();
		this.uploadFileResponseService = uploadFileResponseService;
	}

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @GetMapping("/getall")
    public DataResult<List<UploadFileResponse>> getAll(){
    	return this.uploadFileResponseService.getAll();
    	
    }
    
    
    
    
    @PostMapping("/uploadFile")
    public Result uploadFile(@RequestParam("file") MultipartFile file,UploadFileResponse uploadFileResponse) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/Files/downloadFile/")
                .path(fileName)
                .toUriString();
        
        
        uploadFileResponse.setFileName(fileName);
        uploadFileResponse.setFileDownloadUri(fileDownloadUri);
        uploadFileResponse.setFileType(file.getContentType());
        uploadFileResponse.setSize(file.getSize());
       return uploadFileResponseService.add(uploadFileResponse);
       
      
    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}