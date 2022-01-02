package javaExample04;

public class Lamp {
	public boolean isOn;
	public int illuminance;
	
	public Lamp() {
		isOn = false;
		illuminance = 1;
	}
	
	public Lamp(boolean isOn) {
		this.isOn = isOn;
		illuminance = 1;
	}
	
	public Lamp(boolean isOn, int illuminance) {
		this.isOn = isOn;
		this.illuminance = illuminance;
	}
	
	public void show() {
		if(isOn) {
			System.out.println("조도는 "+illuminance+" 입니다");
		}
		else 
			System.out.println("Lamp가 꺼졌있습니다");
	}
	
	public void turnOnOff() {
		isOn = !isOn;
		show();
	}
	
	public void changeLight() {
		if(isOn) {
			if(illuminance==3)
				illuminance =1;
			else
				++illuminance;
		}
		show();
	}
	
}

