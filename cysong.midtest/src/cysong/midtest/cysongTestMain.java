package cysong.midtest;

public class cysongTestMain {

	public static void main(String[] args) {
		System.out.println("1) 202012667 송채영");
		System.out.println("2) Member 객체 생성 및 출력하기");
		cysongMember gdhong = new cysongMember("홍길동");
		System.out.println(gdhong);
		cysongMember gdKim = new cysongMember("김길동");
		cysongMember gdLee = new cysongMember("이길동");
		cysongMember gdChoi = new cysongMember("최길동");
		cysongMember gdPark = new cysongMember("박길동");
		
		System.out.println("3) Volunteer 추상 클래스 만들기");
		//cysong volunteer1 = new cysongVolunteer("김길동 어린이 돕기",5);
		System.out.println("4) Donation (물적기부) 객체 만들기");
		cysongVolunteer volunteer1 = new cysongDonation("김길동 어린이 돕기",5);
		System.out.println(volunteer1);
		
		System.out.println("5) TalentDonation (재능기부) 객체 만들기");
		cysongVolunteer volunteer2 = new cysongTalentDonation("농촌 미용 봉사활동",2,"미용기술");
		System.out.println(volunteer2);
		
		System.out.println("6) VolunteerManager 객체 만들기");
		cysongVolunteerManager greenjoa = new cysongVolunteerManager("그린세상만들기");
		System.out.println(greenjoa);
		
		System.out.println("7) 봉사활동 추가하기");
		greenjoa.addVolunteer(new cysongTalentDonation("농촌 미용 봉사활동",2,"미용기술"));
		greenjoa.addVolunteer(new cysongDonation("김길동 어린이 돕기",3));
		greenjoa.addVolunteer(new cysongDonation("김길동 어린이 돕기",2));
		greenjoa.addVolunteer(new cysongTalentDonation("독거노인 도배 봉사활동",3,"도배기술"));
		greenjoa.addVolunteer(new cysongTalentDonation("섬마을 미용 봉사활동",2,"미용기술"));

	}

}
