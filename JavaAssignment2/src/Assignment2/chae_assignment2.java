package Assignment2;

import java.util.Scanner;

public class chae_assignment2 {
	public static Scanner scanner = new Scanner(System.in);
	
	static final int ROW = 4;
	static final int COL = 3;

	public static void main(String[] args) {
		String[][] parkingSpace = new String[ROW][COL];
		String[][] parkingNum = new String[ROW][COL];
		int i, j;
		for(i=0;i<parkingSpace.length;i++) {
			for(j=0;j<parkingSpace[i].length;j++) {
				parkingSpace[i][j]="♡";
			}
		}
		while(true) {
			System.out.println("주차관리(202012667 송채영)");
			showParkingSpace(parkingSpace);
			System.out.println("1)주차하기 2) 출차하기 3) 종료");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = scanner.nextInt();
			if(menu == 1) {
				System.out.print("주차할 위치를 선택해 주세요 (입력예 : 2 1) : ");
				int row = scanner.nextInt()-1;
				int col = scanner.nextInt()-1;
				if(row<0 || row >3 || col<0 || col>2) {
					System.out.println("위치 번호를 확인해 주세요. 처음부터 다시 진행해 주세요.");
					continue;
				}
				if(parkingSpace[row][col]=="♥") {
					System.out.println("다른 차량이 주차되어 있습니다. 처음부터 다시 시작해 주세요.");
					continue;
				}
				else {
					System.out.print("차량 번호를 입력해 주세요 (입력예 : 20가1234) : ");
					parkingNum[row][col] = scanner.next();
					System.out.print("차량 번호 "+parkingNum[row][col]+" 맞습니까(y/n)? ");
					String answer = scanner.next();
					if(answer.equals("y")) {
						parkingSpace[row][col] = "♥";
						System.out.println(parkingNum[row][col]+"차량의 주차를 완료하였습니다.");
						}
					else if(answer.equals("n")) {
						parkingNum[row][col]=null;
						System.out.println("처음부터 다시 진행해 주세요.");
						continue;
					}
				}
				
			}
			else if(menu == 2) {
				int a=0;
				System.out.print("차량 번호를 입력해 주세요 : ");
				String exitingNum = scanner.next();
				for(i=0;i<parkingNum.length;i++) {
					for(j=0;j<parkingNum[i].length;j++) {
							if(exitingNum.equals(parkingNum[i][j])) {
								parkingSpace[i][j]="♡";
								parkingNum[i][j] = null;
								System.out.println(exitingNum+" 차량이 출차되었습니다. 안녕히가세요.");
								a++;
							}
						}
					}
				if(a==0) {
					System.out.println("차량이 존재하지 않습니다. 차량번호 확인후 처음부터 다시 진행해 주세요.");
				}
		}
			else if(menu == 3) {
				System.out.println("시스템이 종료됩니다.");
				System.exit(0);
				break;
			}
			else {
				System.out.println("메뉴 번호를 확인 후 다시 입력해 주세요.");
				}
		}
			scanner.close();
		}

	public static void showParkingSpace(String[][] parkingSpace) {
		System.out.println("  1 2 3");
		for(int i=0;i<parkingSpace.length;i++) {
				System.out.print(i+1+" ");
			for(int j=0;j<parkingSpace[i].length;j++) {
				System.out.print(parkingSpace[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
