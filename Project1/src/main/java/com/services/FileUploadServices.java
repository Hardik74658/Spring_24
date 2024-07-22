package com.services;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServices {

//	public void productFileUpload(MultipartFile masterImage) {
//		
//		String path = "C:\\ROYAL\\SPRING\\STS\\Project1\\src\\main\\webapp\\images\\product";
//		
//		try {
//			
//			byte b[] = masterImage.getBytes();
//			
//			File file = new File(path,masterImage.getOriginalFilename());
//			FileUtils.writeByteArrayToFile(file, b);
//			
//		}catch(Exception e ) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public void fileUpload(MultipartFile masterImage,String path) {
		
		
		try {
			
			byte b[] = masterImage.getBytes();
			
			
			File dir = new File(path);
			dir.mkdir();
			
			File file = new File(path,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, b);
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
}
