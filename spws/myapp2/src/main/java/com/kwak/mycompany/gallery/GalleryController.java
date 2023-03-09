package com.kwak.mycompany.gallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kwak.mycompany.common.FileUploadUtil;

@Controller
public class GalleryController {
	@Resource(name = "galleryService")
	GalleryService galleryService;
	
	@RequestMapping(value = "/gallery/list")
	public String gallery_getList(Model model, GalleryDto dto) {
		System.out.println(dto.getSearchKey());
		System.out.println(dto.getSearchKeyword());
		
		model.addAttribute("totalCnt", galleryService.getTotalCnt(dto));
		
		return "gallery/gallery_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/gallery/galleryList_data")
	public Map<String, Object> gallery_listData(GalleryDto dto){
//		여기서 pgSize 지정 가능
//		dto.setPgSize(12);
//		아니면 GalleryDto 에 기본 생성자 만들고 거기서 값 부여
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("****"+dto.getSearchKey());
		System.out.println("****"+dto.getSearchKeyword());
		map.put("totalCnt", galleryService.getTotalCnt(dto));
		map.put("data", galleryService.getList(dto));
		
		return map;
		
	}
	
	@RequestMapping(value = "/gallery/write")
	public String gallery_write() {
		return "gallery/gallery_write";
	}
	@ResponseBody
	@RequestMapping(value = "/gallery/save")
	public Map<String, String> gallery_save(GalleryDto dto, MultipartHttpServletRequest multi){
		Map<String, String> resultMap = new HashMap<String, String>();
		
//		주의사항: 파일 받을 때 변수명하고 태그 이름하고 같으면 문제가 발생한다.
//		String이 아니라 파일 전체가 들어가니깐?
//		파일을 받아서 별도 처리해주고 파일명을 변수에 할당하면 된다.
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContent());
		
		MultipartFile file = multi.getFile("file1");
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(file);
		
		List<String> fileNameList = new ArrayList<String>();
		String path = "C:\\kwak\\spws\\myapp2\\src\\main\\webapp\\upload";
		FileUploadUtil.setFilePath(path); //경로 설정
		
		FileUploadUtil.upload(fileList, fileNameList);
		dto.setImage1(fileNameList.get(0));
		
		System.out.println(dto.getImage1());
		
		galleryService.insert(dto);
		resultMap.put("result", "0");
		resultMap.put("message", "글이 등록 되었습니다.");
		
		return resultMap;
	}
}
