package javaExample04;

public class lampExercise {

	public static void main(String[] args) {
		System.out.println("202012667 송채영");
		System.out.println("======Lamp1======");
		Lamp lamp1 = new Lamp();
		lamp1.turnOnOff();
		lamp1.changeLight();
		
		System.out.println("======Lamp2======");
		Lamp lamp2 = new Lamp(false, 3);
		lamp2.turnOnOff();
		lamp2.changeLight();
		

	}

}
