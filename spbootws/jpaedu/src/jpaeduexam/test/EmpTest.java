package jpaeduexam.test;

import java.util.Scanner;

import jpaedu.exam.dao.EmpDao;

public class EmpTest {
	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		Scanner sc = new Scanner(System.in);
		dao.printAll();
		
//		System.out.print("이름: ");
//		String name = sc.next();
//		dao.searchName(name);
		
//		System.out.print("직업: ");
//		String job = sc.next();
//		dao.searchNameAndJob2(name, job);
		
		dao.groupFunctionTest();
		dao.updateSal(7839, 5500);
		dao.updateJob(7900, "OWNER");
		dao.delete(7934);
		dao.printAll();
		sc.close();
		dao.close();
	}
}
