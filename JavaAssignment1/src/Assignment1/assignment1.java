package Assignment1;

import java.util.Scanner;

public class assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202012667송채영");
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("1) 복리 예금 계산기 2) 구구단 출력하기 3) 종료");
			System.out.print("메뉴를 선택하세요:");
			int menu = sc.nextInt();
			
			if(menu==1) {
				int year =0;
				System.out.println("====== 복리 예금 계산기 ======");
				System.out.print("원금을 입력하세요: ");
				double p = sc.nextInt();
				double p2 = p;
				System.out.print("연이율을 입력하세요:");
				Double ir = sc.nextDouble();
				System.out.println("--------------------");
				System.out.println("년도수   원리금");
				System.out.println("--------------------");
				while(true) {
					year++;
					p =(p*(1+ir/100));
					System.out.printf("%-7d %.2f",year,p);
					System.out.println();
					if(p>p2*2)
						break;
				}
				System.out.println("--------------------");
				System.out.println(year+"년 걸림");
			}
			else if(menu==2) {
				System.out.println("====== 구구단 출력하기 ======");
				int n;
				while(true) {
					System.out.print("출력 단수: ");
					n = sc.nextInt();
					if(n>=1 && n<=8)
						break;
					System.out.println("출력 단수 입력이 잘못되었습니다.");
				}
				for(int i=2;i<10;i+=n) {
					for(int j=1;j<=9;j++) {
						for(int k=i;k<i+n;k++) {
							System.out.print(k+"*"+j+"="+j*k+"\t");
							if(k>=9)
								break;
						}
						System.out.println();
					}
					System.out.println();
				}
				
				
			}
			else if(menu==3) {
				System.out.println("프로그램이 종료됩니다.");
				System.exit(0);
				break;
			}
		}

	}

}
