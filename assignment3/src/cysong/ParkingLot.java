package cysong;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParkingLot {
	private final double parkingPrice;
	int ROW=15;
	int COL=15;
	int number;
	int[][] parkinglot;
	Car[][] parkingCar;
	double income;
	Scanner scan = new Scanner (System.in);
	
	public ParkingLot (String filename,double parkingPrice) {
		this.parkingPrice = parkingPrice;
		
		try {
			Scanner scanner = new Scanner(new File(filename));
			ROW = scanner.nextInt();
			COL = scanner.nextInt();
			parkingCar = new Car[ROW][COL];
			parkinglot = new int[ROW][];
			for(int i = 0; i < ROW; ++i){
				parkinglot[i] = new int [COL];
			    for(int j = 0; j < COL; ++j){
			    	parkinglot[i][j] = scanner.nextInt();
			    }
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}
	
	public void showParkingLot() {
		System.out.println("========================================");
		for(int i=0;i<COL;i++) {
			System.out.print("\t"+(i+1));
		}
		System.out.println("\n");
		
		for(int i=0;i<ROW;i++) {
				System.out.print(i+1);
			for(int j=0;j<COL;j++) {
				switch(parkinglot[i][j]) {
				case 0: System.out.print("\t"+"☆"); break;
				case 1: System.out.print("\t"+"○"); break;
				case 2: System.out.print("\t"+"◇"); break;
				case 3: System.out.print("\t"+"★"); break;
				case 4: System.out.print("\t"+"●"); break;
				case 5: System.out.print("\t"+"◆"); break;
				}
			}
			System.out.println("\n");
		}
		System.out.println("========================================");
	}

	public void Parking(Car c) {
		showParkingLot();
			
		while(true) {
			System.out.print("주차할 자리를 선택하세요(예, 1 1) ==>");
			int R = scan.nextInt()-1;
			int C = scan.nextInt()-1;
			
			if(parkinglot[R][C]>2) {
				System.out.println("이미 주차된 구역입니다.다른 자리를 선택해주세요.");
				continue;
			}
			
			boolean check = false;
			switch(parkinglot[R][C]) {
			case 0:
				check = checkCarForDisabledPerson(c);
				if(!check)
					System.out.print("장애인 전용 주차 구역입니다. 다른 자리를 선택해주세요.");
				break;
			case 1: 
				check = checkSmallCar(c);
				if(!check)
					System.out.print("소형차 전용 주차 구역입니다. 다른 자리를 선택해주세요.");
				break;
			case 2:
				check = true;
				break;
			}
			if(check == true) {
				parkinglot[R][C] = parkinglot[R][C]+3;
				parkingCar[R][C] = c;
				System.out.println("주차가 완료되었습니다.");
				showParkingLot();
				return;
			}else
				System.out.println("다른 자리를 선택해주세요");
		}
		
	}
		
	private boolean checkSmallCar(Car c) {
		if(c instanceof SmallCar)
			return true;
		else
			return false;
	}
	
	private boolean checkCarForDisabledPerson(Car c) {
		if(c instanceof CarForDisabledPerson)
			return true;
		else
			return false;
	}
	
	
	public void PullOut() {
		System.out.print("출차할 차량번호를 입력하세요 : ");
		String carNumber = scan.next();
		for(int i=0;i<parkinglot.length;i++) {
			for(int j=0;j<parkinglot[i].length;j++) {
				if(parkingCar[i][j]!=null) {
					if(carNumber.equals(parkingCar[i][j].getCarNumber())) {
						income += parkingCar[i][j].getParkingprice(this.parkingPrice);
						System.out.println("주차가격은 "+parkingCar[i][j].getParkingprice(this.parkingPrice)+" 입니다. 안녕히가세요.");
						parkinglot[i][j] = parkinglot[i][j]-3;
						return;
					}
				}
			}		
		}
		System.out.println("차량번호를 확인해주세요.");
	}

	@Override
	public String toString() {
		String str = "기본주차료 : "+this.parkingPrice;
		str += "\n전체수입 : " + income+ "원";
		return str;
	}
	
	
}
