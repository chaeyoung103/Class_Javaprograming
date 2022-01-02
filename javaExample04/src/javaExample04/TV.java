package javaExample04;

public class TV{
	public boolean power=false;
	public int channel=10;
	public int volume;
	
	public TV(boolean p) {
		power = p;
	}
	
	public TV(boolean p, int c) {
		power = p;
		channel = c;
	}
	
	public TV() {
		// TODO Auto-generated constructor stub
	}

	public void show() {
		if(power) {
			System.out.println("현재"+channel+"번 시청중");
			System.out.println("현재볼륨높이: "+volume);
		}
		else {
			System.out.println("TV전원 꺼져있음");
		}
	}
	
	public void powerOnOff() {
		power = !power;
		show();
	}
	
	public void channelUp() {
		if(power)
			++channel;
		show();
	}
	
	public void channelDown() {
		if(power)
			--channel;
		show();
	}
	
	public void volumeUp() {
		if(power)
			if(volume>=0&&volume<20)
				++volume;
		show();
	}
	
	public void volumeDown() {
		if(power)
			if(volume>0&&volume<=20)
				--volume;
		show();
	}
	
	public void changeChannel(int ch) {
		if(power)
			channel = ch;
		show();
	}
	
	public void changeVolume(int vol) {
		if(power)
			if(vol>=0&&vol<=20)
				volume = vol;
		show();
	}
}
