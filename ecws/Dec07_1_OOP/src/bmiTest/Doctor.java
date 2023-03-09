package bmiTest;

public class Doctor {
//	Patient p; -> Doctor가 평생을 관리해온 환자 느낌

//	public void start(Patient p) 업무 시작할 때 필요한 재료 Patient p

	public void start() {
		Patient p = callPatient();

//		해당 작업에서만 임시로 필요하고 다음엔 필요 없는 Patient p
		ask(p);
		calculate(p);
		judge(p);
		tellResult(p);
	}

	public Patient callPatient() {
//		   Patient(callPatient()의 결과물)
		return new Patient();
	}

	public void ask(Patient p) {
//		void 자리에 Patient: String, double 둘 다 포함되어 있음
		System.out.print("이름: ");
		p.name = p.tellName();
//		start()의 p와 깉은 p에 정보를 넣어준거라 return 안해도 된다구

		System.out.print("키: ");
		p.height = p.tellHeight();
		if (p.height > 3) {
			p.height /= 100;
		} // 환자가 센치미터로 얘기해도 의사가 알아서 미터로 변환해주기

		System.out.print("몸무게: ");
		p.weight = p.tellWeight();

	} // 이미 원본에 영향이 가니까(함수는 참조형) 굳이 return할 필요 없음

	public double calculate(Patient p) {
		p.bmi = p.weight / (p.height * p.height);
		return p.bmi;
	}

	public void judge(Patient p) {
		p.status = "저체중";
//		return이 없을 때 else를 안 쓰는 방법 -> 저체중이었는데 조건에 부합하면 변수 값이 바뀔 것
		if (p.bmi >= 35) {
			p.status = "고도비만";
		} else if (p.bmi >= 30) {
			p.status = "중도비만";
		} else if (p.bmi >= 25) {
			p.status = "경도 비만";
		} else if (p.bmi >= 23) {
			p.status = "과체중";
		} else if (p.bmi >= 18.5) {
			p.status = "정상";
		} 
	}
	
	public void tellResult(Patient p) {
		System.out.printf("BMI: %.1f\n", p.bmi);
		System.out.printf("%s씨는 %s\n", p.name, p.status);
	}
}
