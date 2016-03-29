package com.chenyu.employ.common.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static String fileUpload(MultipartFile file, HttpServletRequest request, String filePath) {
		String path = request.getSession().getServletContext().getRealPath(filePath);
        if (file.getSize() <= 0) {
            return null;
        }
		String fileName = System.currentTimeMillis()
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public static boolean deleteFile(HttpServletRequest request,String fileName, String filePath) {
		String path = request.getSession().getServletContext().getRealPath("");
		if(fileName==null)return false;
		File file = new File(path,fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			return true;
		} 
		return false;
	}
}