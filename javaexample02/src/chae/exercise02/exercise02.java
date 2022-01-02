package chae.exercise02;

import java.util.Scanner;

public class exercise02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202012667 송채영");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학번:");
		int stdnum = scanner.nextInt();
		System.out.print("이름:");
		String name = scanner.next();
		System.out.print("나이:");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("주소:");
		String addr = scanner.nextLine();
		
		System.out.println("학번:"+stdnum);
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		System.out.println("주소:"+addr);
		
		scanner.close();
	}

}
