package cysong.midtest;

public class cysongMember {

	private String memberName;
	private int actNum;
	private int donationTotal;
	
	public cysongMember(String memberName) {
		this.memberName = memberName;
		actNum = 0;
		donationTotal=0;
	}
	
	public String getMemberName() {
		return memberName;
	}

	public int getActNum() {
		return actNum;
	}

	public int getDonationTotal() {
		return donationTotal;
	}

	@Override
	public String toString() {
		String str = "회원이름 : "+this.memberName;
		str+= "\n자원봉사 참여 횟수 : "+this.actNum+"회";
		str+= "\n기부 총액 : "+this.donationTotal+"원";
		
		return str;
	}
	
	

}
