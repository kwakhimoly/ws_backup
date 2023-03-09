package jpaexam.address;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AddressManager {
	Scanner sc = new Scanner(System.in);
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
	EntityManager em = factory.createEntityManager();

	public void start() {
		int menu = 0;
		while (true) {
			menu = showMenu();
			if (menu == 0) {
				close();
				break;
			} else if (menu == 1) {
				register();
			} else if (menu == 2) {
				int schkey = search();
				if (schkey == 1) {
					searchName();
				} else if (schkey == 2) {
					searchPhone();
				} else if (schkey == 3) {
					searchEmail();
				} else {
					System.out.println("검색 조건을 잘못 입력하셨습니다.");
					showMenu();
					continue;
				}
			} else if(menu==3) {
				update();
			} else if(menu==4) {
				delete();
			} else if(menu==5) {
				printAll();
			}
		}
	}
	
	public int showMenu() {
		System.out.println("메뉴");
		System.out.print("1.등록\n2.검색\n   1.이름으로\n   2.전화번호\n   3.이메일\n3.수정(번호)\n4.삭제(번호)\n5.전체출력\n0.종료\r\n");
		System.out.print("메뉴 선택: ");
		int menu = sc.nextInt();
		return menu;
	}
	
	public void close() {
		em.close();
		factory.close();
		sc.close();	
	}
	
	public void register() {
		AddressDto dto = new AddressDto();
		
		System.out.print("이름 : ");
		String name = sc.next();
		dto.setName(name);
		
		System.out.print("이메일 : ");
		String email = sc.next();
		dto.setEmail(email);
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		dto.setPhone(phone);
		
		dto.setWdate(LocalDateTime.now());
		
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
	}
	
	public int search() {
		System.out.print("검색 조건: ");
		int schkey = sc.nextInt();
		return schkey;
	}
	
	public void searchName() {
		System.out.print("이름: ");
		String name = sc.next();
		String sql = "select t from AddressDto t where t.name like :name";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		q.setParameter("name","%"+name+"%");
		
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void searchPhone() {
		System.out.print("전화번호: ");
		String phone = sc.next();
		String sql = "select t from AddressDto t where t.phone like :phone";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		q.setParameter("phone","%"+phone+"%");
		
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void searchEmail() {
		System.out.print("이메일: ");
		String email = sc.next();
		String sql = "select t from AddressDto t where t.email like :email";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		q.setParameter("email","%"+email+"%");
		
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void printAll() {
		String sql = "select t from AddressDto t order by t.seq";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		
		List<AddressDto> list = q.getResultList();
		list.stream().forEach(item->{
			System.out.println(item);
		});
	}
	
	public void update() {
		
		System.out.print("수정할 연락처 등록 번호: ");
		int seq = sc.nextInt();
		
		String sql = "select t from AddressDto t where seq = :seq";
		TypedQuery<AddressDto> q = em.createQuery(sql, AddressDto.class);
		q.setParameter("seq", seq);
		
		AddressDto dto = new AddressDto();
		
		try {
		dto = q.getSingleResult();
		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
			return;
		}
		em.getTransaction().begin();
		
		System.out.print("이름: ");
		String name = sc.next();
		dto.setName(name);
		System.out.print("전화번호: ");
		String phone = sc.next();
		dto.setPhone(phone);
		System.out.print("이메일: ");
		String email = sc.next();
		dto.setEmail(email);
		
		em.getTransaction().commit();
		System.out.println("수정 완료");
	}
	
	public void delete() {
		System.out.print("삭제할 연락처 등록 번호: ");
		int seq = sc.nextInt();
		AddressDto dto = new AddressDto();
		try {
			dto = em.find(AddressDto.class, seq);
		} catch (Exception e) {
			System.out.println("삭제 실패");
			printAll();
			return;
		}
		em.getTransaction().begin();
		em.remove(dto);
		em.getTransaction().commit();
		System.out.println("삭제 완료");
	}
	
}
