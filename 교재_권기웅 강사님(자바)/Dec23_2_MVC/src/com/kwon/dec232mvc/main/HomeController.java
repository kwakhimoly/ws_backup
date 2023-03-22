package com.kwon.dec232mvc.main;

// MainController
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		int x = cs.getX();
		int y = cs.getY();
		CalcResult cr = Calculator.calculate(x, y);
		cs.printResult(cr);
		cs.cut();
	}
}
