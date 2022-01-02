package javaexample3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class TestMain {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		lab08();
		scan.close();
	}
	public static void lab08() {
		String filename = "map.txt";
		int[][] map = readMap(filename);
		if(map!=null)
			showMap(map);
	}
	public static void showMap(int[][] map) {
		for(int[] row: map) {
			for(int col:row) {
				switch(col) {
				case 0 : System.out.print("■"); break;
				case 1 : System.out.print("□"); break;
				case 2 : System.out.print("＠"); break;
				}
			}
			System.out.println();
		}
		
	}
	public static int[][] readMap(String filename) {
		int[][]map = null;
		File file = new File(filename);
		
		try {
			Scanner fileScan = new Scanner(file);
			final int ROW = fileScan.nextInt();
			final int COL = fileScan.nextInt();
			map = new int[ROW][COL];
			for(int i=0; i<map.length;i++) {
				for(int j=0; j<map[i].length;j++) {
					map[i][j] = fileScan.nextInt();
					}
			}
			fileScan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		}
		return map;
	}
	public static void lab07() {
		int[][] arr = makeAraay2D();
		printArray2D(arr);
	}
	public static void printArray2D(int[][] arr) {
		for(int i=0; i<arr.length;i++) {
			System.out.print(i+"층 : ");
			for(int j : arr[i]) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}
	private static int[][] makeAraay2D() {
		
		System.out.print("층의 개수를 입력하세요 : ");
		final int ROW = scan.nextInt();
		int[][] arr = new int[ROW][];
		Random rand = new Random();
		for(int i=0;i<ROW;i++) {
			System.out.print(i+"층 : ");
			final int COL = scan.nextInt();
			arr[i] = new int[COL];
			for(int j=0; j<COL;j++)
				arr[i][j] = rand.nextInt(100);
		}
		return arr;
	}
	public static void lab06() {
		String[] name = new String[] {"홍길동","김길동","고길동","이길동"};
		int[][] score = new int[][] {
			{10,20,30,0},
			{20,60,50,0},
			{70,20,80,0},
			{75,90,60,0}
		};
		
		for(int[] arr : score) {
			for(int i=0; i<arr.length-1;i++) {
				arr[arr.length-1] += arr[i];
			}
		}
		for(int i=0; i<score.length;i++) {
			System.out.print(name[i]+">>");
			int k=0;
			for(int j:score[i]) {
				if(k == 3)
					System.out.print(" : ");
				System.out.print(j+" ");
				k++;
			}
			System.out.println();
		}
	
	}
	
	public static void lab05() {
		int[] answer = {1,2,3,3,2,1};
		
		int[] std1 = {1,2,3,4,1,2};
		int[] std2 = {10,20,30,40,10,20};
		
		int[] std = new int[12];
		
		System.arraycopy(std1,0,std,0,std1.length);
		System.arraycopy(std2,0,std,std1.length,std1.length);
		
		for(int i : std) {
			System.out.print(i+" ");
		}
		System.out.println();
//		System.out.print("정답 :");
//		for(int i: answer) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
//		
//		System.out.print("학생 :");
//		for(int i: std1) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
//		int[] quizResult = getQuizResult(answer,std1.clone());
//		
//		System.out.print("결과 :");
//		for(int i: quizResult) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		
//		System.out.print("학생 :");
//		for(int i: std1) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//	}
//	public static int[] getQuizResult(int[] answer, int[] std1) {
//		for(int i=0; i<answer.length;i++) {
//			if(std1[i]==answer[i])
//				std1[i] = 1;
//			else 
//				std1[i] = 0;
//			
//		}
//		return std1;
	}
	public static void lab04() {
		int[] lotto = makeLotto();
		for(int i : lotto)
			System.out.print(i+" ");
	}
	private static int[] makeLotto() {
		int[] lotto = new int[6];
		Random rand = new Random();
		for(int i =0; i<lotto.length;i++) {
			lotto[i] = rand.nextInt(45)+1;
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
			
		}
		
		return lotto;
	}
	public static void lab03() {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {1,2,3,4};
		
		boolean result = arrEquals(arr1,arr2);
		System.out.println(arr1+"\t"+arr2);
		System.out.println(result?"같음":"같지않음");
	}
	public static boolean arrEquals(int[] arr1, int[] arr2) {
		
		if(arr1.length != arr2.length)
			return false;
		for(int i=0; i<arr1.length;i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	public static void lab01() {
		//선택정렬
		int[] list = {10,50,30,60,70,20};
		
		System.out.print("정렬전 : ");
		for(int i : list) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int minIndex;
		for(int i=0;i<list.length-1;i++) {
			minIndex = i;
			for(int j=i+1;j<list.length;j++) {
				if(list[j] < list[minIndex]) {
					minIndex = j;
				}
			}
//			if(minIndex != i) {
//				int temp = list[minIndex];
//				list[minIndex] = list[i];
//				list[i] = temp;
			list[i] = list[i]^list[minIndex];
			list[minIndex] = list[i]^list[minIndex];
			list[i] = list[i]^list[minIndex];
				
			}
		System.out.print("정렬후 : ");
		for(int i : list) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
