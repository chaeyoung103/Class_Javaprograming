package assignment5;


public class Word {
	String eng; 
	String kor; 
	
	int count=0;
	
	// 각각의 객체 처리 메소드를 정의합니다.
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//생성자
	public Word(String eng, String kor) {
		this.eng = eng;
		this.kor = kor;
	}
}
