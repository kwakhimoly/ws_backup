package com.kwak.codingtest;

public class Chicken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(97));
		
		StringBuffer buffer = new StringBuffer();

		buffer.append("select a.m_seq, a.m_title, a.m_writer, a.m_poster, a.m_rate, a.m_date, a.pg, a.rnum from");
		buffer.append("(select m_seq, m_title, m_writer, m_poster, m_rate, m_date, ");
		buffer.append("row_number() over(order by m_seq desc) as rnum, ");
		buffer.append("ceil(row_number() over(order by m_seq desc)/12)-1 pg ");
		buffer.append("from tb_review) A  where pg=0 order by rnum desc;");
		
		System.out.println(buffer.toString());
	}

	public static int solution(int chicken) {
		int answer = 0;
		int coupon = chicken;
		
		while(coupon>=10) {
			chicken = coupon/10;
			answer += chicken;
			coupon %= 10;
			coupon += chicken;
		}
		
		
		return answer;
	}
}
