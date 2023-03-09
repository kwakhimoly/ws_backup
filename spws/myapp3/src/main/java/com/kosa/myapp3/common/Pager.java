package com.kosa.myapp3.common;

import javax.servlet.http.HttpServletRequest;

public class Pager {
	public static String makeTag(HttpServletRequest request, int totalCnt, int pgSize) {
		int pgGroupSize = 10; 
		int cpage; 
		String pg = request.getParameter("pg");
		
		if(pg==null||pg.equals("")) {
			pg="0";
		}
		cpage = Integer.parseInt(pg); 
		
		int pageTotal = (int)Math.ceil((float)totalCnt/pgSize)-1;
		System.out.println(pageTotal);
		
		String firstLabel = "first";
		String prevLabel = "prev";
		String nextLabel = "next";
		String lastLabel = "last";
		int start, end;
		
		
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
			if(i==cpage) {				
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
				+" onclick='goPage("+page+")' style='background-color: lavender; color: black' >"+label+"</a></li>";
		return s;
	}
}
