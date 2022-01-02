package chae.example03;

public class TestMain03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = -8;
		int c = a | b;
		
		String temp ="00000000000000000000000000000000";
		String aStr = temp + Integer.toBinaryString(a);
		String aBiStr = aStr.substring(aStr.length()-32);
		
		System.out.println("a : "+aBiStr);
		System.out.println("b : "+Integer.toBinaryString(b));
		System.out.println("c : "+Integer.toBinaryString(c));

	}

}
