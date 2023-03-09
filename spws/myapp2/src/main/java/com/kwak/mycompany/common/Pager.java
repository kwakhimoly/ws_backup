package com.kwak.mycompany.common;

import javax.servlet.http.HttpServletRequest;

public class Pager {
	public static String makeTag(HttpServletRequest request, int totalCnt, int pgSize) {
		//totalCnt = 데이터 전체 개수
		//pgSize = 10; // 한 페이지에 10개씩 보겠다.
		int pgGroupSize = 5; // 한 그룹 당 5개씩 보겠다.
		int cpage; //현재 페이지
		String pg = request.getParameter("pg");
		
		if(pg==null||pg.equals("")) {
			pg="0";
		}
		cpage = Integer.parseInt(pg); //현재 페이지 정보 저장하기
		
		int pageTotal = (int)Math.ceil((float)totalCnt/pgSize)-1;
		// 0 1 2 3 .... 32 : 33페이지
		// total->float형으로 전환하면 pgSize도 float으로 전환해서 연산을 수행
		// 327.0/10.0 -> ceil(32.7) = 33.0 -> 33으로
		System.out.println(pageTotal);
		
		//String path=""; -> 안 쓸 건데 왜 넣었지?..
		String firstLabel = "first";
		String prevLabel = "prev";
		String nextLabel = "next";
		String lastLabel = "last";
		int start, end;
		
		
		//0~4
		//5~9
		//10~14
		//15~19
		start = cpage/pgGroupSize*pgGroupSize;
		end = start+pgGroupSize;
		if(end>pageTotal) {
			end=pageTotal+1;
		}
		System.out.println(String.format("start %d end %d cpage %d", start, end, cpage));
		StringBuffer buffer = new StringBuffer();
		buffer.append("<ul class=\'pagination justify-content-center\'>");
		buffer.append(makeLink(0, firstLabel));
		
		if(cpage>0) {
			buffer.append(makeLink(cpage-1, prevLabel));
		}
		
		for(int i=start; i<end; i++) {
			if(i==cpage) {	//선택된 페이지는 css에 active가 있어야 한다.			
				buffer.append(makeActiveLink(i, (i+1)+""));
			} else {
				buffer.append(makeLink(i, (i+1)+""));				
			}
		}
		
		if(cpage<pageTotal) {
			buffer.append(makeLink(cpage+1, nextLabel));
		}
		
		buffer.append(makeLink(pageTotal, lastLabel));
		buffer.append("</ul>");
		return buffer.toString();
	}
	public static String makeLink(int page, String label) {
		String s = "<li class='page-item'><a class='page-link' href='#none'"
					+" onclick='goPage("+page+")' style='color:black' >"+label+"</a></li>";
		return s;
	}
	public static String makeActiveLink(int page, String label) {
		String s = "<li class='page-item'><a class='page-link' href='#none'"
				+" onclick='goPage("+page+")' style='background-color: aliceblue; color: black' >"+label+"</a></li>";
		return s;
	}
}
