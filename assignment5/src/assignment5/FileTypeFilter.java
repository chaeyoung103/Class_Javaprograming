package assignment5;


import java.io.File;
import javax.swing.filechooser.*;

// 파일 형식 필터 클래스입니다.
public class FileTypeFilter extends FileFilter{

	// 확장자와 설명 변수입니다.
	private final String extension;
	private final String description;
	
	// 필터 클래스 생성자입니다.
	public FileTypeFilter(String extension, String description)
	{
		this.extension = extension;
		this.description = description;
	}

	/* 파일 불러오기 및 저장하기 관련 처리 함수들입니다. */
	@Override
	public boolean accept(File file) {
		if(file.isDirectory())
		{
			return true;
		}
		return file.getName().endsWith(extension);
	}

	@Override
	public String getDescription() {
		return description + String.format(" (*%s)", extension);
	}
}
