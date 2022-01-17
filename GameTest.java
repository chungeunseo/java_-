package com.ssafy.ws01.step3;
import java.util.Scanner;

public class GameTest {
	public static int game() { 
		System.out.println("가위바위보 하나 중 입력: ");
		Scanner sc = new Scanner(System.in);
		String user = sc.next(); 
		int com = (int) (Math.random() * 3); 
		String[] arr = { "가위", "바위", "보" }; 
		if (user.equals(arr[com])) {
			System.out.println("비겼습니다!!!");
			return 0;
		} else if (user.equals("가위") && arr[com].equals("보")) { // 사용자가 이길 경우 1을 리턴
			System.out.println("이겼습니다!!!");
			return 1;
		} else if (user.equals("바위") && arr[com].equals("가위")) {
			System.out.println("이겼습니다!!!");
			return 1;
		} else if (user.equals("보") && arr[com].equals("바위")) {
			System.out.println("이겼습니다!!!");
			return 1;
		} else {
			System.out.println("졌습니다!!!");
			return -1;
		}
	}
	
	public static void printFinalResult(int userWin, int comWin, int draw) {
		if (userWin == comWin) { 
			while (userWin == comWin) { // 사용자 승리와 컴퓨터 승리가 달라지면 반복문 깨짐
				int score = game();
				switch (score) {
				case 0 : draw += 1; break; 
				case 1: userWin += 1; break; 
				case -1: comWin += 1; break; 
				}
			}
		}
		if (userWin > comWin) {
			System.out.println("### 사용자 승!!!");
		}
		if (userWin < comWin) {
			System.out.println("### 컴퓨터 승!!!");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		int choice = sc.nextInt();
		int userWin = 0;
		int comWin = 0;
		int draw = 0;
		
		int [ ] gameCycle = {5, 3, 1};
		int [ ] fastWin = {3, 2, 1};
			for (int i = 0; i < gameCycle[choice-1]; i++) { 
				int score = game();
				switch (score) {
				case 0: draw += 1; break;
				case 1: userWin += 1; break;
				case -1: comWin += 1; break;
				}
				if(userWin == fastWin[choice-1] || comWin == fastWin[choice-1]) break;
			}
		printFinalResult(userWin, comWin, draw);
		}

}
