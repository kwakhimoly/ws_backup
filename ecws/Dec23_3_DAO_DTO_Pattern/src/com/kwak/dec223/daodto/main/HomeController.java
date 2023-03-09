package com.kwak.dec223.daodto.main;



public class HomeController {
	public static void main(String[] args) {
		BookDAO bd = new BookDAO();
		try {
			bd.connect();
			bd.getInfo(bd.getCon());
			bd.getResult(bd);
			ConsoleScreen.print(bd);
			bd.disconnect(bd.getRs(), bd.getPstmt(), bd.getCon());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
