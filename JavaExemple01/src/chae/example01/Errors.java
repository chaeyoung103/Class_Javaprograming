package chae.example01;
//public class errors ->파일이름과 클래스명이 다름
public class Errors {
	
	//public Static main(string[] args) { -> static과 String의 s가 대문자 소문자 뒤바뀜, main 앞에 void가 빠짐
	public static void main(String[] args) {
		System.out.println("202012667 송채영");
		//System.out.println(“이 프로그램은 많은 오류를 가지고 있다.”); ->따옴표 잘못쓰임
		System.out.println("이 프로그램은 많은 오류를 가지고 있다.");
		//System.0ut.println(“그러나 프로그램이 이 문장을 출력된다면”) ->영어o가 숫자0으로 잘못쓰임, 문장 마지막에 ;가 빠짐, 따옴표 잘못쓰임
		System.out.println("그러나 프로그램이 이 문장을 출력된다면");
		//System.out.Println(“모든 오류를 고친 것이다.); -> println의 p가 대문자로 잘못쓰임, 따옴표가 잘못쓰이고 한쪽만 쓰임
		System.out.println("모든 오류를 고친 것이다.");
  }
}
