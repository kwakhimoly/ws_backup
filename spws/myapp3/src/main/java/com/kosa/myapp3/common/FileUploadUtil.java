package com.kosa.myapp3.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	static String filePath = ""; 

	private FileUploadUtil() {}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FileUploadUtil.filePath = filePath;
	}
	
	public static String getFileName(String orifilename) {
		String newFilename = "";
		int pos = orifilename.lastIndexOf(".");
		String ext = ""; 
		String filename = "";
		if(pos!=-1) {
			filename=orifilename.substring(0, pos); 
			ext = orifilename.substring(pos+1); 
		} else {
			filename = orifilename;
			ext="";
		}
		
		System.out.println("파일이름: "+filename);
		System.out.println("확장자: "+ext);
		
		newFilename = filename+"."+ext;
		File newFile = new File(filePath+"/"+newFilename);
		int i = 1;
		while(newFile.exists()) { 
			newFilename = filename+"("+i+")"+"."+ext;
			i++;
			newFile = new File(filePath+"/"+newFilename); 			
		}
		System.out.println(newFilename);
		return newFilename;
	}
	
	public static void upload(List<MultipartFile> fileList, List<String> fileNameList) {
		File file = new File(filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		if(fileList!=null&&fileList.size()>0) {
			for (MultipartFile mfile : fileList) {
				String orifilename = mfile.getOriginalFilename();
//				파일 첨부 안 했을 때의 오류 처리를 해야 한다.
				System.out.println("filename: "+orifilename);
//				: null 안나오고 공백 나옴
				if(orifilename==null||orifilename.equals("")) {
					fileNameList.add("");
					continue;
//					이 다음 코드를 건너 뛰고 다시 for문으로 이동
				}
				String newFileName = getFileName(orifilename);
				try {
					mfile.transferTo(new File(filePath+"/"+newFileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				fileNameList.add(newFileName);
			}
		}
	}
}
