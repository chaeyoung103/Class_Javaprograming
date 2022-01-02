package cysong;

public class Car {
	protected String ownerName;
	protected String carNumber;
	
	public Car (String ownerName, String carNumber) {
		this.ownerName = ownerName;
		this.carNumber = carNumber;
	}

	public String getCarNumber() {
		return this.carNumber;
	}
	
	public double getParkingprice(double parkingPrice) {
		return parkingPrice;
	}

	@Override
	public String toString() {
		String str = "차량소유주 : "+this.ownerName;
		str += "\n차량번호 : " + this.carNumber;
		return str;
	}

	
	
	

}
