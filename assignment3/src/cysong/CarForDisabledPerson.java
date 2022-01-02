package cysong;

public class CarForDisabledPerson extends Car{
	private String disabledPersonNumber;
	private String disabledDegree;

	public CarForDisabledPerson(String ownerName, String carNumber,String disabledPersonNumber,String disabledDegree) {
		super(ownerName, carNumber);
		this.disabledPersonNumber = disabledPersonNumber;
		this.disabledDegree = disabledDegree;
	}
	

	public String getDisabledDegree() {
		return this.disabledDegree;
	}


	@Override
	public double getParkingprice(double parkingPrice) {
		if(this.disabledDegree.equals("중증")) {
			return parkingPrice*0.3;//70%할인
		}
		else {
			return parkingPrice*0.4;//%60%할인
		}
	}

	@Override
	public String toString() {
		return super.toString()+"\n장애인등록번호 : " + this.disabledPersonNumber+"\n장애정도 : " + this.disabledDegree;
	}
	

}
