package chae.example01;

import java.io.IOException;

public class TestMain01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		int code = System.in.read();
//		char ch = (char) System.in.read();a
//		System.out.printf("%2$d, %1$c\n", ch,code);
		
		int code;
		while((code = System.in.read()) != -1) {
			System.out.println("code = "+code);
		}

	}

}
