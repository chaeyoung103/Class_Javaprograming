package chae.exercise04;

import java.util.Scanner;
import java.util.Random;

public class exercise04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202012667송채영");
		
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("가위(0), 바위(1), 보(2)중에 하나를 입력해주세요.");
		System.out.print("입력: ");
		int user = scan.nextInt();
		int com = r.nextInt(3);
		//사용자 
		if(user==0)
			System.out.println("user : 가위");
		else if(user==1)
			System.out.println("user : 바위");
		else
			System.out.println("user : 보");
		//컴퓨터
		if(com==0)
			System.out.println("com : 가위");
		else if(user==1)
			System.out.println("com : 바위");
		else
			System.out.println("com : 보");
		//승패결정
		
		if(user==0) {
			if(com==1)
				System.out.println("user 패배");
			else if(com==2)
				System.out.println("user 승리");
			else 
				System.out.println("무승부");
		}
		else if(user==1) {
			if(com==2)
				System.out.println("user 패배");
			else if(com==0)
				System.out.println("user 승리");
			else 
				System.out.println("무승부");
		}
		else if(user==2) {
			if(com==0)
				System.out.println("user 패배");
			else if(com==1)
				System.out.println("user 승리");
			else 
				System.out.println("무승부");
		}
	}

}
