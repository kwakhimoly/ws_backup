package com.kwak.mycompany.fileupload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kwak.mycompany.common.FileUploadUtil;

@Controller
public class FileController {
	
	@RequestMapping(value = "/fileupload")
	public String fileupload() { //jsp로 이동
		return "/fileupload/fileupload";
	}
	
	@RequestMapping(value = "/fileupload/save")
	public String fileuploadsave(MultipartHttpServletRequest multi) { //파일 업로드 할 때
//		MultipartHttpServletRequest 객체의 getFile 함수를 호출한다
//		이 함수가 업로드된 파일의 정보를 갖고 있다. input type="file" 태그의 name 속성 값을 가져온다.
		MultipartFile file = multi.getFile("file1"); //input 태그의 name 속성 값 ""에 넣기
		String path = "C:\\kwak\\spws\\myapp2\\src\\main\\webapp\\upload";
		
		/* FileUploadUtil 에서 처리.
		File dir = new File(path);
		
		if(!dir.exists()) { //디렉토리(path 경로 속 폴더)가 존재하지 않으면
			dir.mkdirs(); //해당 디렉토리를 생성
		}
		
		try {
		//	임시 서버에 파일은 이미 올라와 있음 -> 이 파일을 내가 지정한 위치로 옮긴다.
		//	=> 스프링부트부터는 다른 방식 사용(스프링 3까지만)
		//	"새로운파일명" -> 기존의 파일명 가져와서 반영해서 만들지 아니면 완전히 새로 만들지 정해야 함
			file.transferTo(new File(path+"//a.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("file1"));
		List<String> fileNameList = new ArrayList<String>();
		fileNameList.add("filename1");
		
		FileUploadUtil.setFilePath(path);
		FileUploadUtil.upload(multiList, fileNameList);
		return "redirect:/";
	}
}
