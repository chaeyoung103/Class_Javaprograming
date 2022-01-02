package cysong.midtest;

public class cysongTalentDonation extends cysongVolunteer{
	private int currentNumber;
	private String talentName;

	public cysongTalentDonation(String volunteerName, int volunteerNumber,String talentName) {
		super(volunteerName, volunteerNumber);
		this.currentNumber=0;
		this.talentName = talentName;
	}

	@Override
	public String toString() {
		String str = "자원봉사명 : "+this.volunteerName;
		str+= "\n참여가능 인원 : "+this.volunteerNumber;
		str+= "\n현재 참여인원 : "+this.currentNumber;
		str+= "\n봉사할 재능 : "+this.talentName;
		str+= "\n참여자 명단 (기부금액이 큰 순서)";
		str+=("\n----------------------------------");
		if(this.currentNumber==0) {
			str+=("\n신청자가 없습니다.");
		}
		
		return str;
	}

}
