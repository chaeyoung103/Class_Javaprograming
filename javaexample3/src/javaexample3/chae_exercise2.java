package javaexample3;

public class chae_exercise2 {

	public static void main(String[] args) {
		System.out.println("202012667 송채영");
		
		String[] name = new String[] {"홍길동","김길동","고길동","이길동"};
		int[][] score = new int[][] {
			{10,20,30,0},
			{20,30,40,0},
			{10,25,30,0},
			{30,30,40,0}
		};
		int[] rank = new int[] {1,1,1,1};
		
		for(int[] arr : score) {
			for(int i=0; i<arr.length-1;i++) {
				arr[arr.length-1] += arr[i];
			}
		}
		
		for(int i =0;i<rank.length;i++) {
			for(int j=0;j<score.length;j++) {
				if(score[i][3]<score[j][3])
					rank[i]++;
			}
		}
		
		for(int i=0; i<score.length;i++) {
			System.out.print(name[i]+">>");
			int k=0;
			for(int j:score[i]) {
				if(k == 3)
					System.out.print(" : ");
				System.out.print(j+" ");
				k++;
			}
			System.out.print(": "+rank[i]);
			System.out.println();
		}

	}

}
