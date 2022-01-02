package cysong;

public class SmallCar extends Car {
	private int displacement;

	public SmallCar(String ownerName, String carNumber,int displacement) {
		super(ownerName, carNumber);
		this.displacement = displacement;
	}

	@Override
	public String toString() {
		return super.toString()+"\n배기량 : " + this.displacement+"cc";
	}

	@Override
	public double getParkingprice(double parkingPrice) {
		return parkingPrice*0.5;
	}
	

}
