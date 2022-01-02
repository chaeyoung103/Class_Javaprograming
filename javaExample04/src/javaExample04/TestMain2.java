package javaExample04;

import java.util.Scanner;

public class TestMain2 {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void replaceChar(char[] input, char char1, char char2) {
		for(int i=0;i<input.length;i++) {
			if(input[i]==char1)
				input[i] = char2;
		}
	}
	
	public static char[] replaceChar(String input, char char1, char char2) {
		char[] charArr = input.toCharArray();
		replaceChar(charArr,char1,char2);
		return charArr;
	}
	
	public static void lab2() {
		System.out.print("문자열을 입력하세요 : ");
		String userInput = scan.nextLine();
		
		System.out.print("찾을 문자를 입력하세요 : ");
		String userChar1 = scan.nextLine();
		char char1 = userChar1.charAt(0);
		
		System.out.print("바꿀 문자를 입력하세요 : ");
		String userChar2 = scan.nextLine();
		char char2 = userChar2.charAt(0);
		
		char[] charArr = userInput.toCharArray();
		replaceChar(charArr,char1, char2);
		System.out.println(charArr);
	}

	public static void main(String[] args) {
		lab2();
	}
}
