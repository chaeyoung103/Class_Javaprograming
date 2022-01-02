package javaexample3;

import java.util.Random;

public class chae_exercise1 {

	public static void main(String[] args) {
		System.out.println("202012667 송채영");
		int[] Lotto = new int[6];
		Lotto = makeLotto();
		lab02(Lotto);
		for(int i : Lotto)
			System.out.print(i+" ");
		
	}

	private static int[] makeLotto() {
		int[] lotto = new int[6];
		Random rand = new Random();
		for(int i =0; i<lotto.length;i++) {
			lotto[i] = rand.nextInt(45)+1;
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
			
		}
		
		return lotto;
	}
	public static void lab02(int[] Lotto) {
		int minIndex;
		for(int i=0;i<Lotto.length-1;i++) {
			minIndex = i;
			for(int j=i+1;j<Lotto.length;j++) {
				if(Lotto[j] < Lotto[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int temp = Lotto[minIndex];
				Lotto[minIndex] = Lotto[i];
				Lotto[i] = temp;
				
			}
		}
	}
}

