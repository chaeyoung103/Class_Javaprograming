package javaExample04;

public class TestMain {
	public static void main(String[] args) {
		
		System.out.println("202012667 송채영");
		System.out.println("========TV1========");
		TV tv1 = new TV();
		tv1.powerOnOff();
		tv1.changeChannel(10);
		tv1.changeVolume(15);
	}
}