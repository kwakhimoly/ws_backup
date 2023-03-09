package com.kwak.dec234.project.main;

public class HomeController {

	public static void main(String[] args) {
		ConsoleScreen v = new ConsoleScreen();
		ManageDAO m = new ManageDAO();
		int menu = 0;
		int page = 0;

		try {
			v.InputSystem();
			while (true) {
				menu = v.showMainMenu();
				if (menu == 13) {
					break;
				} else if (menu == 1) {
					System.out.println("영화관 등록에는 영화관의 이름, 위치, 상영관 수 정보가 필요합니다.");
					CGV cgv = v.setCGVInfo();
					v.printResult(m.setCGV(cgv));
				} else if (menu == 2) {
					String name = v.setCGVName();
					v.printResult(m.deleteCGV(name));
				} else if (menu == 3) {
					page = m.getCGVCount();
					int cgvPage = v.showSelectCGVPageMenu(page);
					v.getCGVInfo(m.getCGV(cgvPage));
				} else if (menu == 4) {
					System.out.println("영화 등록에는 영화 제목, 감독, 개봉일, 러닝타임 정보가 필요합니다.");
					Movie movie = v.setMovieInfo();
					v.printResult(m.setMovie(movie));
				} else if (menu == 5) {
					String m_title = v.setMovieTitle();
					v.printResult(m.deleteMovie(m_title));
				} else if (menu == 6) {
					page = m.getMovieCount();
					int mvPage = v.showSelectCGVPageMenu(page);
					v.getMovieInfo(m.getMovie(mvPage));
				} else if (menu == 7) {
					Theater theater = v.setTheaterInfo();
					String result = m.setTheater(theater);
					if (result.equals("fail")) {
						v.printFailTheater();
						page = m.getCGVCount();
						int cgvPage = v.showSelectCGVPageMenu(page);
						v.getCGVInfo(m.getCGV(cgvPage));
					} else {
						v.printResult(result);
					}
				} else if (menu == 8) {
					Theater tt = v.setTheaterCGVName();
					String t_name = tt.getT_name();
					String t_cgv_name = tt.getT_cgv_name();
					v.printResult(m.deleteTheater(t_name, t_cgv_name));
				} else if (menu == 9) {
					page = m.getTheaterCount();
					int ttPage = v.showSelectCGVPageMenu(page);
					v.getTheaterInfo(m.getTheater(ttPage));
				} else if (menu == 10) {
					System.out.println(
							"상영 영화 등록에는 등록할 상영관의 고유번호, 등록할 영화의 고유번호, " 
					+ "상영관의 이름, 상영 영화관의 이름, 영화 제목 정보가 필요합니다.");
					System.out.println("등록하고자 하는 영화의 제목을 검색하여 영화의 고유 번호를 확인하세요.");
					String title = v.setRMTitle();
					v.getRMInfoM(m.getMEvery(title));
					System.out.println("등록하고자 하는 상영관의 영화관 이름을 검색하여 상영관의 고유 번호와 상영 영화관 이름을 확인하세요.");
					String name = v.setRMName();
					v.getRMInfoT(m.getTEvery(name));
					Every every = v.setRMInfo();
					v.printResult(m.setRM(every));
				} else if (menu == 11) {
					Every ev = v.setRMtm();
					String r_m_title = ev.getM_title();
					String r_t_cgv_name = ev.getT_cgv_name();
					String r_t_name = ev.getT_name();

					String result = m.deleteRM(r_m_title, r_t_cgv_name, r_t_name);
					v.printResult(result);
				} else if (menu == 12) {
					page = m.getRMCount();
					int rmPage = v.showSelectCGVPageMenu(page);
					v.showRMInfo(m.getRunMovie(rmPage));
				}
			}

			v.bye();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 오류");
		}
	}

}
