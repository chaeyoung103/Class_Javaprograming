package chae.example04;

import java.util.Scanner;

public class TestMain04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("알파벳 대소문자 또는 숫자 : ");
		String str = scan.next();
		char a = str.charAt(0);
		
		if(a>='a' && a<='z')
			System.out.println("문자"+a+"는 소문자 입니다.");
		else if(a>='A' && a<='Z')
			System.out.println("문자"+a+"는 대문자 입니다.");
		else if(a>='0' && a<='9')
			System.out.println("문자"+a+"는 숫자 입니다.");
		else
			System.out.println("문자"+a+"는 알파벳 또는 숫자가 아닙니다.");
		
		scan.close();
	}

}
