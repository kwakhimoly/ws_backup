package com.kwak.mycompany.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// 파일 업로드 전담 클래스
public class FileUploadUtil {
	static String filePath = ""; // 물리적 경로가 null값이 오면 안됨

//	생성자를 private로 만들면 객체 생성 불가
	private FileUploadUtil() {}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FileUploadUtil.filePath = filePath;
	}
	
	public static String getFileName(String orifilename) {
		String newFilename = "";
//		1.파일명과 확장자를 분리한다.
//		오른쪽에서 .가 있는 위치값은 찾는다.
//		오른쪽 끝에서부터 찾는다.
		int pos = orifilename.lastIndexOf(".");
		String ext = ""; //확장자
		String filename = "";
		if(pos!=-1) {
			filename=orifilename.substring(0, pos); //파일명만 추출
			ext = orifilename.substring(pos+1); //확장자만 추출하기
		} else {
//			확장자가 없는 경우(.이 없는 경우): pos==-1
			filename = orifilename;
			ext="";
		}
		
		System.out.println("파일이름: "+filename);
		System.out.println("확장자: "+ext);
		
		newFilename = filename+"."+ext;
		File newFile = new File(filePath+"/"+newFilename);
		int i = 1;
		while(newFile.exists()) { //파일이 있다면
//			새로운 파일명을 만든다. a(1).jpg, a(2).jpg ...
			newFilename = filename+"("+i+")"+"."+ext;
			i++;
			newFile = new File(filePath+"/"+newFilename); //다시 확인			
		}
		System.out.println(newFilename);
		return newFilename;
	}
	
//	컨트롤러에서 MultipartFile 객체 리스트를 전달하면 파일을 저장 후 파일의 이름 목록을 전달.
//	파일명 충돌 방지 수단. 
//	a.jpg, a(1).jpg, ...
//	202302021145001133.jpg
	public static void upload(List<MultipartFile> fileList, List<String> fileNameList) {
		File file = new File(filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
//		첨부파일이 있을 때
		if(fileList!=null&&fileList.size()>0) {
			for (MultipartFile mfile : fileList) {
//				1.본래 파일명을 가져온다.
				String orifilename = mfile.getOriginalFilename();
//				2.파일명이 충돌 안 나게 바꾼다.
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
