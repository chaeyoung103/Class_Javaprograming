package chae.exercise05;

import java.util.Scanner;

public class exercise05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202012667송채영");
		Scanner scan = new Scanner(System.in);
		int count =0;
		String a = "greenjoa";
		
		while(count<3) {
			System.out.print("암호를 입력하세요:");
			String pw = scan.next();
			if(pw.equals(a)) {
				System.out.print("환영합니다.");
				System.exit(0);
				break;
			}
			else {
				System.out.println("암호가 틀립니다.");
				count++;
			}
			
		}
		System.out.print("접속을 거부합니다.");
		System.exit(0);

	}

}
