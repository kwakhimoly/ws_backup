package com.kwon.dec233ddp.main;

import java.util.ArrayList;

public class HomeController {
	public static void main(String[] args) {
		ArrayList<Book> books = BookDAO.getBook();
		ConsoleScreen.printResult(books);
	}
}
