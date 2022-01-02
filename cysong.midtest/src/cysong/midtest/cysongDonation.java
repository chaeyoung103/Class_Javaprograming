package cysong.midtest;

public class cysongDonation extends cysongVolunteer{
	private int currentNumber;
	private int totalDonation;
	

	public cysongDonation(String volunteerName, int volunteerNumber) {
		super(volunteerName, volunteerNumber);
		this.currentNumber=0;
		this.totalDonation=0;
		}

	@Override
	public String toString() {
		String str = "자원봉사명 : "+volunteerName;
		str+= "\n참여가능 인원 : "+this.volunteerNumber;
		str+= "\n현재 참여인원 : "+this.currentNumber;
		str+= "\n기부금 총액 : "+this.currentNumber;
		str+= "\n참여자 명단 (기부금액이 큰 순서)";
		str+=("\n----------------------------------");
		if(this.currentNumber==0) {
			str+=("\n신청자가 없습니다.");
		}
		
		return str;
	}

}
