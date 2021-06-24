package com.douzone.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	private static final String SAVE_PATH = "/uploads-jblog";
	private static final String URL_BASE = "/assets/images/logo";
	
	public String restore(MultipartFile file) {
		String url = null;
		if(file.isEmpty()) {
			return url;
		}
		try {
	
			String originFilename = file.getOriginalFilename();
			String extName =  originFilename.substring(originFilename.lastIndexOf('.') + 1);
			String saveFilename = generateSaveFilename(extName);
			
			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH +"/"+saveFilename);
			os.write(data);
			os.close();
			
			url = URL_BASE +"/"+ saveFilename;
		
		} catch (IOException e) {
			throw new RuntimeException();
		}
		return url;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}
}
