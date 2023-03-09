package com.kwak.dec223.daodto.teacher;

import java.util.ArrayList;

public class ConsoleScreen {
	
	public static void printResult(ArrayList<Book> books) {
		for (Book book : books) {
			System.out.println(book.getName());
			System.out.println(book.getPrice());
			System.out.println(book.getGenre());
			System.out.println("================");
		}
	}
}
