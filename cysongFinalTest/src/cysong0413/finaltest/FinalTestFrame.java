package cysong0413.finaltest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



@SuppressWarnings("serial")
public class FinalTestFrame extends JFrame {
	
	VolunteerManager cysong = new VolunteerManager("좋은세상만들기"); // 본인이름 이니셜 객체
	
	public FinalTestFrame() {
		this("202012667 송채영"); // 본인 학번 이름
	}
	
	public FinalTestFrame(String title) {
		super(title);
		Container frame = this.getContentPane();
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}	
	
	public void init() {		
		MyLabel label= new MyLabel();
		this.add(label, BorderLayout.NORTH);
		JButton stop = new JButton("stop");
		stop.addActionListener(new ActionListener() {
			// 퀴즈를 진행하는 함수입니다.
			public void actionPerformed(ActionEvent e) {
	
			}
			
		});
		//퀴즈시작 버튼설정
		stop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		stop.setBounds(111, 80, 126, 50);
		this.add(stop);

	}
	
	@SuppressWarnings("serial")
	class MyLabel extends JLabel implements Runnable{
		
		SimpleDateFormat date = new SimpleDateFormat("yyy년 MM월 dd일 HH시 mm분 ss초");
		
		MyLabel(){
			this.setFont(new Font("궁서체", Font.BOLD, 24));
			this.setOpaque(true);
			this.setBackground(Color.GREEN);
			this.setHorizontalAlignment(CENTER);
			Thread th = new Thread(this);
			th.start();
			
		}

		@Override
		public void run() {
			while(true) {
				this.setText(date.format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}


	
}




















