package com.kwak.dec223.daodto.teacher;

import java.util.ArrayList;

public class HomeControl {

	public static void main(String[] args) {
		ArrayList<Book> books = BookDAO.getBook();
		ConsoleScreen.printResult(books);

	}

}
