package cysong.midtest;


public class cysongVolunteerManager {
	private String groupName;
	private int registeredVolunteer;
	private cysongVolunteer[] voluns;
	private int count =0;
	
	public cysongVolunteerManager(String groupName){
		this.groupName = groupName;
		this.registeredVolunteer=0;
		voluns = new cysongVolunteer[3];
	}
	
	public void addVolunteer(cysongVolunteer vol) {
		if(this.count < 3) {
			voluns[count++] = vol;
			System.out.println("등록이 잘 되었습니다.");
		}
		else {
			System.out.println("더 이상 추가 할수 없습니다.");
		}
	}

	@Override
	public String toString() {
		String str = "봉사단체명 : "+this.groupName;
		str+="\n등록된 봉사활동 : "+this.registeredVolunteer;
		str+=("\n----------------------------------");
		if(this.registeredVolunteer==0) {
			str+="\n등록된 봉사활동이 없습니다.";
		}
		return str;
	}
	

}
