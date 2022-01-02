package assignment5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


//여기서 부터는 메인화면을 구성하는 부분입니다.
public class Main {
	private JFrame frame;

	// 만들어둔 Word 클래스를 이용하여 단어장 리스트 생성하였습니다.
	static ArrayList<Word> vocabulary = new ArrayList<Word>();

	// 단어장 목록 작성을 위해 각각 단어 리스트 모델을 작성하였습니다. 
	static DefaultListModel listEnglishModel = new DefaultListModel();
	static DefaultListModel listKoreanModel = new DefaultListModel();

	// 단어 리스트를 작성하였습니다. 
	static JList listEnglishList = new JList();
	static JList listKoreanList = new JList();
	
	//메인화면에서 사용되는 textfield를 선언하였습니다.
	private JTextField TotalCountText;
	private JTextField addEnglishText;
	private JTextField addKoreanText;
	private JTextField searchEnglishText;
	private JTextField searchKoreanText;

	// 프로그램 실행부분입니다.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//프레임 화면이 원래 윈도우 화면 중간에 맞춰 보이도록 하였습니다. 
					Main window = new Main();
					window.frame.setVisible(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					window.frame.setLocation(dim.width/2 - window.frame.getSize().width/2, dim.height/2 - window.frame.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 프로그램을 생성하는 부분입니다. 
	public Main() {
		init();
	}

	// 현재의 단어 목록을 세팅하는 함수입니다.
	private void listSetting(){
		// 리스트 모델을 초기화합니다.
		listEnglishModel = new DefaultListModel();
		listKoreanModel = new DefaultListModel();
		// 현재 단어장 리스트에 있는 모든 정보를 리스트 모델에 담습니다.
		for(int i = 0; i < vocabulary.size(); i++)
		{
			listEnglishModel.addElement((i + 1) + ". " + vocabulary.get(i).getEng());
			listKoreanModel.addElement((i + 1) + ". " + vocabulary.get(i).getKor());
		}
		// 각각의 리스트가 리스트 모델을 포함하여 보여지게 됩니다.
		listEnglishList.setModel(listEnglishModel);
		listKoreanList.setModel(listKoreanModel);
		// 위를 바탕으로 단어의 총개수 결과를 나타냅니다.
		TotalCountText.setText(vocabulary.size() + " 개");
	}

	// 프레임 내부를 초기화하는 함수입니다.
	private void init() {

		//프레임 기본 설정
		frame = new JFrame();
		frame.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		frame.setTitle("영어 단어장(202012667 송채영)");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 메뉴바를 생성하여 파일을 불러올수있도록 합니다.
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 782, 26);
		frame.getContentPane().add(menuBar);

		// 파일이라는 메뉴를 생성합니다.
		JMenu menu = new JMenu("파일");
		menu.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		menuBar.add(menu);

		//파일 메뉴 안에 기능을 추가합니다.
		JMenuItem newFile = new JMenuItem("새 파일");
		newFile.addActionListener(new ActionListener() {
			// 새 파일을 여는 액션 함수입니다.
			public void actionPerformed(ActionEvent e) {
				vocabulary = new ArrayList<Word>();
				listSetting();
			}
		});
		newFile.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		menu.add(newFile);

		// 메뉴바의 불러오기 버튼입니다.
		JMenuItem getFile = new JMenuItem("불러오기");
		getFile.addActionListener(new ActionListener() {
			// 파일을 불러오기
			public void actionPerformed(ActionEvent e) {
				// filechooser을 이용하여 파일을 선택하도록 합니다.
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("파일 불러오기");
				fs.setFileFilter(new FileTypeFilter(".txt","data file"));
				int result = fs.showOpenDialog(null);
				// 파일 선택에 성공했을 때
				if(result == JFileChooser.APPROVE_OPTION)
				{
					// 단어장을 초기화합니다.
					vocabulary = new ArrayList<Word>();
					// 선택한 파일을 불러옵니다.
					File file = fs.getSelectedFile();
					try
					{
						Scanner scan = new Scanner(new BufferedReader(new FileReader(file.getPath())));
						while(scan.hasNext())
						{
							// tab를 기준으로 영단어와 해석을 구분하여 받아들입니다.
							String[] word = scan.nextLine().split("\t");
							vocabulary.add(new Word(word[0], word[1]));
						}
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				listSetting();
			}
		});
		getFile.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		menu.add(getFile);

		// 메뉴바의 저장하기 버튼입니다.
		JMenuItem saveFile = new JMenuItem("저장하기");
		saveFile.addActionListener(new ActionListener() {
			// 만약 파일이 단어추가 기능 등에 의해 수정되었다면 다시 파일을 저장하는 액션 함수입니다.
			public void actionPerformed(ActionEvent e) {
				// 파일을 선택할 수 있도록 합니다.
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("파일 저장하기");
				fs.setFileFilter(new FileTypeFilter(".txt", "data file"));
				int result = fs.showSaveDialog(null);
				// 파일 선택에 성공한 경우입니다.
				if(result == JFileChooser.APPROVE_OPTION)
				{
					// 선택한 파일을 파일 객체로 설정합니다.
					File file = fs.getSelectedFile();
					try
					{
						// 파일을 열어 해당 파일에 모든 단어 리스트를 출력하도록 합니다.
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath() + ".txt")));
						for(int i = 0; i < vocabulary.size(); i++)
						{
							bw.write(vocabulary.get(i).getEng() + "\t" + vocabulary.get(i).getKor() + "\r\n");
						}
						// 버퍼를 닫습니다.
						bw.close();
					}
					catch (Exception e2)
					{
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
				listSetting();
			}
		});
		saveFile.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		menu.add(saveFile);

		// 메뉴바 종료하기 버튼
		JMenuItem exitProgram = new JMenuItem("종료하기");
		exitProgram.addActionListener(new ActionListener() {
			// 버튼을 눌렀을때 종료할 수 있도록 하는 함수 입니다.
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitProgram.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		menu.add(exitProgram);

		// <만든사람>패널 과제설명에 따라 이름,학번,사진이 담긴 패널입니다.  
		//한눈에 알아보기 좋게 title border 와 line border을 이용하여 제목을 넣고 가장자리에 선을 넣어주었습니다.
		JPanel addPanel = new JPanel();
		addPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "만든 사람", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addPanel.setBounds(14, 26, 343, 150);
		frame.getContentPane().add(addPanel);
		addPanel.setLayout(null);

		//imageicon을 통해 이미지를 넣어주고 라벨을 이용하여 이미지와 학번,이름을 한번에 볼수 있도록 했습니다.
		ImageIcon img = new ImageIcon("me3.jpg");	
		JLabel addnameLabel = new JLabel("<html><body>이름 :송채영<br>학번: 202012667</body></html>",img,JLabel.LEFT);
		addnameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addnameLabel.setVerticalTextPosition(JLabel.CENTER);
		addnameLabel.setHorizontalTextPosition(JLabel.RIGHT);
		addnameLabel.setBounds(26, 7, 300, 140);
		addPanel.add(addnameLabel);

		// <단어 추가> 패널 
		//각각 textfield에 영어와 한글을 작성한뒤 단어추가 버튼을 누르면 단어가 추가되도록 하였습니다.
		JPanel addWordPanel = new JPanel();
		addWordPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "단어 추가", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addWordPanel.setBounds(14, 175, 343, 150);
		frame.getContentPane().add(addWordPanel);
		addWordPanel.setLayout(null);

		JLabel addEnglishLabel = new JLabel("영어");
		addEnglishLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addEnglishLabel.setBounds(26, 36, 62, 18);
		addWordPanel.add(addEnglishLabel);

		JLabel addKoreanLabel = new JLabel("한글");
		addKoreanLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addKoreanLabel.setBounds(26, 80, 62, 18);
		addWordPanel.add(addKoreanLabel);

		addEnglishText = new JTextField();
		addEnglishText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addEnglishText.setBounds(138, 35, 174, 24);
		addWordPanel.add(addEnglishText);
		addEnglishText.setColumns(10);

		addKoreanText = new JTextField();
		addKoreanText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addKoreanText.setColumns(10);
		addKoreanText.setBounds(138, 79, 174, 24);
		addWordPanel.add(addKoreanText);

		// 단어 추가 버튼입니다.
		JButton addWordButton = new JButton("단어추가");
		addWordButton.addActionListener(new ActionListener() {
			// 단어 추가 버튼을 눌렀을 때의 액션입니다.
			public void actionPerformed(ActionEvent arg0) {
				// 하나의 단어를 단어장에 추가합니다.
				vocabulary.add(new Word(addEnglishText.getText(), addKoreanText.getText()));
				// 리스트 뷰를 초기화하여 단어추가가 적용되도록 합니다. textfield도 초기화 해줍니다.
				listSetting();
				addEnglishText.setText("");
				addKoreanText.setText("");
			}
		});
		addWordButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		addWordButton.setBounds(207, 110, 97, 25);
		addWordPanel.add(addWordButton);

		//<단어 목록> 패널: 불러온 파일의 단어가 모두 보여 지도록 합니다.
		JPanel listPanel = new JPanel();
		listPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "단어목록", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		listPanel.setBounds(371, 26, 397, 300);
		frame.getContentPane().add(listPanel);
		listPanel.setLayout(null);

		//단어개수가 제한되어 있지 않기 때문에 scrollpane을 이용하여 리스트를 보여줍니다.
		JScrollPane listEnglishPane = new JScrollPane();
		listEnglishPane.setBounds(14, 35, 185, 250);
		listPanel.add(listEnglishPane);

		listEnglishList = new JList();
		listEnglishList.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		listEnglishPane.setViewportView(listEnglishList);

		JScrollPane listKoreanPane = new JScrollPane();
		listKoreanPane.setBounds(198, 35, 185, 250);
		listPanel.add(listKoreanPane);

		listKoreanList = new JList();
		listKoreanList.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		listKoreanPane.setViewportView(listKoreanList);

		JLabel listEnglishLabel = new JLabel("영어");
		listEnglishLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		listEnglishLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listEnglishLabel.setBounds(71, 10, 62, 18);
		listPanel.add(listEnglishLabel);

		JLabel listKoreanLabel = new JLabel("한글");
		listKoreanLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		listKoreanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listKoreanLabel.setBounds(259, 10, 62, 18);
		listPanel.add(listKoreanLabel);

		//<객관식 퀴즈>패널: 단어의 총개수를 보여주며 퀴즈시작 버튼과 오답노트를 보여주는 버튼이 존재합니다.
		JPanel quizPanel = new JPanel();
		quizPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "객관식 퀴즈", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		quizPanel.setBounds(14, 330, 344, 220);
		frame.getContentPane().add(quizPanel);
		quizPanel.setLayout(null);

		// 퀴즈시작 버튼입니다.
		JButton startButton = new JButton("퀴즈 시작");
		startButton.addActionListener(new ActionListener() {
			// 퀴즈를 진행하는 함수입니다.
			public void actionPerformed(ActionEvent e) {
				//퀴즈시작버튼을 눌렀을때 밑에서 만들어둔 dialog 클래스를 선언하여 버튼을 누르면 다이얼로그가 뜨도록 합니다.
				dialog D; 
				if(e.getSource() == startButton){
					D = new dialog();
				}
			}
		});
		//퀴즈시작 버튼설정
		startButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		startButton.setBounds(111, 80, 126, 50);
		quizPanel.add(startButton);

		//오답노트 버튼생성
		JButton note = new JButton("오답노트");
		note.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e1) {
				//오답노트버튼을 눌렀을때 밑에서 만들어둔 dialog2 클래스를 선언하여 버튼을 누르면 다이얼로그가 뜨도록 합니다.
				dialog2 F; 
				if(e1.getSource() == note){
					F = new dialog2();
				}
			}
		});
		//오답노트버튼 설정
		note.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		note.setBounds(111, 150, 126, 50);
		quizPanel.add(note);

		//총 단어수 라벨입니다.
		JLabel TotalCountLabel = new JLabel("총 단어 수");
		TotalCountLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		TotalCountLabel.setBounds(24,28, 119, 33);
		quizPanel.add(TotalCountLabel);

		//총개수 textfield입니다. 파일을 불러올때 개수가 적용되어 보입니다.
		TotalCountText = new JTextField();
		TotalCountText.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalCountText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		TotalCountText.setEditable(false);
		TotalCountText.setBounds(147, 27, 163, 36);
		quizPanel.add(TotalCountText);
		TotalCountText.setColumns(10);

		// <단어검색>패널: 영어를 치면 한글을 검색해주는 기능을 나타내는 패널입니다.
		JPanel searchWordPanel = new JPanel();
		searchWordPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "단어 검색", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		searchWordPanel.setBounds(371, 330, 397, 220);
		frame.getContentPane().add(searchWordPanel);
		searchWordPanel.setLayout(null);

		JLabel searchEnglishLabel = new JLabel("영어");
		searchEnglishLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		searchEnglishLabel.setBounds(26, 60, 62, 25);
		searchWordPanel.add(searchEnglishLabel);

		JLabel searchKoreanLabel = new JLabel("한글");
		searchKoreanLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		searchKoreanLabel.setBounds(26, 130, 62, 25);
		searchWordPanel.add(searchKoreanLabel);

		searchEnglishText = new JTextField();
		searchEnglishText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		searchEnglishText.setBounds(138, 59, 174, 30);
		searchWordPanel.add(searchEnglishText);
		searchEnglishText.setColumns(10);
		
		searchEnglishText.addActionListener(new ActionListener() {

			// 영어에 단어를 입력하고 enter를 쳤을때 단어를 검색하여 뜻을 찾아주는 함수 입니다.
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==searchEnglishText) {
					String sWord = searchEnglishText.getText();
					sWord = sWord.trim();
					boolean findResult = false;

					for (Word word : vocabulary) {
						if(word!=null && word.eng.equals(sWord)) {
							searchKoreanText.setText(word.getKor());
							findResult = true;
							break;
						}
					}
					//단어장에 있는 단어가 아니라면 단어장에 등록된 단어가 아니라는 오류를 띄워줍니다.
					if(!findResult) {
						JOptionPane.showMessageDialog(null, "단어장에 등록된 단어가 아닙니다.", "오류", JOptionPane.WARNING_MESSAGE);
					}	
				}
			}
		});

		//한글 textfield입니다.
		searchKoreanText = new JTextField();
		searchKoreanText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		searchKoreanText.setColumns(10);
		searchKoreanText.setBounds(138, 129, 174, 30);
		searchWordPanel.add(searchKoreanText);

	}
}

//오답노트 버튼을 눌렀을때 뜨는 다이얼로그 클래스입니다.
class dialog2 extends JDialog{

	static ArrayList<Word> fail;
	
	JLabel result;
	
	

	//dialog2생성자
	public dialog2() {

		fail = Main.vocabulary;
		setTitle("오답노트");
		Container c = getContentPane();
		c.setLayout(null);

		String resultMessage = "";

		//횟수에따라 순서가 변경된 오답노트를 출력해줍니다
		resultMessage = checkFrequency();

		this.result = new JLabel("");
		result.setText(resultMessage);
		result.setLocation(30,10);
		result.setSize(400,350);
		c.add(result);
		setSize(450,400);
		setVisible(true);
	}
	
	//틀린횟수에따라 단어의 순서를 변경해줍니다.
	public String checkFrequency() {
		String resultMessage="";
		Collections.sort(fail,(o1,o2)->(o1.count-o2.count)*-1);
		for(int i=0;i<21;i++) {
			if(fail.get(i).count>0)
				resultMessage +="<html><body>틀린단어	" + fail.get(i).getEng() + ":	" + fail.get(i).getKor() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;틀린 횟수 : "+ fail.get(i).count+ "<br />";
		}
		resultMessage += "</body></html>";
		return resultMessage;
	}
}

//퀴즈 시작버튼을 눌렀을때 나타나는 다이얼로그 클래스입니다.
class dialog extends JDialog{

	int example[];
	int answer1;
	int answerIndex;
	int cnt = 0;
	int num = 1;

	long start_time=0;
	long end_time=0;

	String eng;

	static ArrayList<Word> w;

	JRadioButton[] answer;

	JLabel Q1;
	JLabel CNT;
	JLabel NUM;
	
	//dialog 생성자
	public dialog() {
		Font f = new Font("맑은 고딕",Font.PLAIN,30);

		w = Main.vocabulary;

		setTitle("객관식 퀴즈");
		start_time = System.currentTimeMillis();

		Container c = getContentPane();
		c.setLayout(null);

		makeexam();
		makebutton();

		//각각의 라디오버튼 선택시 이벤트를 설정해줍니다.
		for(int i = 0; i < 4; i++)
			answer[i].addItemListener(new MyItemListener());

		//라디오버튼 각각 위치와 사이즈를 지정해줍니다.
		answer[0].setLocation(20,80);
		answer[0].setSize(100,80);
		answer[1].setLocation(120,80);
		answer[1].setSize(100,80);
		answer[2].setLocation(220,80);
		answer[2].setSize(100,80);
		answer[3].setLocation(320,80);
		answer[3].setSize(100,80);

		//다음으로 넘어가는 버튼을 생성해 줍니다.
		JButton next = new JButton("next");
		next.setLocation(50,200);
		next.setSize(100,20);
		next.addActionListener(new myactionlistener());
		c.add(next);

		//종료하기 버튼을 생성해 줍니다.
		JButton Exit = new JButton("종료");
		Exit.setLocation(250,200);
		Exit.setSize(100,20);
		Exit.addActionListener(new myactionlistener());
		c.add(Exit);

		//맞춰야할 단어를 보여주는 라벨을 생성해줍니다.
		this.Q1 = new JLabel(eng);
		Q1.setLocation(150,10);
		Q1.setSize(200,50);
		Q1.setFont(f);
		c.add(Q1);

		//아래쪽에 맞은 횟수를 나타내어 주는 라벨을 생성해줍니다.
		this.CNT = new JLabel("맞은 횟수");
		CNT.setLocation(150,300);
		CNT.setSize(400,20);
		c.add(CNT);

		this.NUM = new JLabel("1번");
		NUM.setLocation(120,10);
		NUM.setSize(200,50);
		c.add(NUM);

		//각각 라디오버튼 다이얼로그에 띄워줍니다.
		for(int i = 0; i < 4; i++)
			c.add(answer[i]);

		//다이얼로그 사이즈설정
		setSize(450,400);
		setVisible(true);


	}
	//답의 인덱스를 생성자로 주어 객관식 4개를 만들어내는 함수입니다.
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // 
		int index;
		for(int i=0; i<n.length; i++) {
			do {
				index = (int)(Math.random()*w.size());
			} while(index == answerIndex || exists(n, index)); 
			n[i] = index;
		}

		for(int i=0; i<n.length; i++) ex[i] = n[i];
		return (int)(Math.random()*n.length); 
	}
	
	//4개의 객관식중에 중복되는 것이 있는지 확인하는 함수입니다.
	private boolean exists(int n[], int index) {
		for(int i=0; i<n.length; i++) {
			if(n[i] == index)
				return true;
		}
		return false;
	}
	//퀴즈로 낼 영어단어를 랜덤하게 고르는 함수입니다.
	private void makeexam() {
		this.answerIndex = (int)(Math.random()*w.size()); 
		this.eng = w.get(answerIndex).getEng();
		this.example = new int[4];
		this.answer1 = makeExample(example,answerIndex);
		example[answer1] = answerIndex;    
	}

	//만들어낸 객관식을 라디오버튼에 넣는 함수 입니다.
	private void makebutton() {
		this.answer= new JRadioButton[4];
		answer[0] = new JRadioButton(w.get(example[0]).getKor());
		answer[1] = new JRadioButton(w.get(example[1]).getKor());
		answer[2] = new JRadioButton(w.get(example[2]).getKor());
		answer[3] = new JRadioButton(w.get(example[3]).getKor());

	}

	//next버튼, 종료버튼을 눌렀을때 실행되는 함수 입니다.
	class myactionlistener implements ActionListener{

		public void actionPerformed(ActionEvent e) {


			JButton N = (JButton)e.getSource();
			if(N.getText().equals("next")) {
				//영어 단어를 다시 고릅니다.
				makeexam();
				if(num<10) {
					Q1.setText(eng);
					for(int j = 0; j<4; j++) {
						//세팅되어있는 객관식으로 다시 세팅해줍니다.
						answer[j].setText(w.get(example[j]).getKor());
						//선택되었던 버튼을 모두 선택해제 해줍니다.
						answer[j].setSelected(false);}
					//문제 번호 증가
					num++;
					//맞은횟수 증가
					CNT.setText("맞은 횟수 "+Integer.toString(cnt));
					NUM.setText(Integer.toString(num)+"번");
				}
				else {
					//문제가 10번을 넘어가면 종료라고 띄운 뒤 맞은 개수 걸린시간을 출력해 줍니다.
					Q1.setText("종료");
					NUM.setText(null);
					end_time = System.currentTimeMillis();
					CNT.setText("10문제중"+Integer.toString(cnt)+"개 맞추셨고, 총"+(int)((end_time - start_time)/1000.0)+"초 소요되었습니다.");
				}
			}

			JButton X = (JButton)e.getSource();
			if(X.getText().equals("종료")) {
				//종료버튼을 누르면 다이얼로그를 없애줍니다.
				dispose();

			}
		}
	}

	//라디오버튼을 선택했을때 나타나는 함수입니다.
	class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JRadioButton b = (JRadioButton)e.getSource();
			//선택되지않으면 아무것도 return 하지 않습니다.
			if(e.getStateChange()==ItemEvent.DESELECTED){
				return;
			}
			//선택되었을 때
			if(b.isSelected()){
				//답이 맞았을때는 라디오버튼의 텍스트를 맞았습니다.로 바꿔줍니다.
				if (b.getText().equals(w.get(example[answer1]).getKor())) {
					b.setText("맞았습니다.");
					cnt++;
				}
				//답이 틀렸을때는 텍스트를 틀렸습니다.로 바꾸고 오답노트를 위해 vocaburary에 count를 증가시켜 줍니다. 
				else if(!b.getText().equals(w.get(example[answer1]).getKor())){
					b.setText("틀렸습니다.");
					Main.vocabulary.get(example[answer1]).count++;
				}
			}
		}
	}
}

