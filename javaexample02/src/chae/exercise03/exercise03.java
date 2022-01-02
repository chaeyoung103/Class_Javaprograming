package chae.exercise03;

public class exercise03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202012667송채영");
		
		int rgb = 0xffffffff;
		String strRgb = Integer.toBinaryString(rgb);
		System.out.println("현재 색상: "+strRgb);
		
		int a = 0xff;
		rgb = rgb^(a<<8);
		strRgb = Integer.toBinaryString(rgb);
		System.out.println("변경 색상: "+strRgb);
		
		

	}

}
