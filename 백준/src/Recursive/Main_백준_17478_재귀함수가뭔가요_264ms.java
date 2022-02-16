package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_17478_재귀함수가뭔가요_264ms {
	
	static int N;
	static String[] msg1 = new String[4];
	static String[] msg2 = new String[3];
	static String mark = "____";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		msg1[0] = "\"재귀함수가 뭔가요?\"";
		msg1[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		msg1[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		msg1[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		
		msg2[0] = "\"재귀함수가 뭔가요?\"";
		msg2[1] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		msg2[2] = "라고 답변하였지.";
		printMsg(0);
	}
	
	static void printMsg(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < 3; i++) {
				printMark(cnt);
				System.out.println(msg2[i]);
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < cnt; j++) {
				System.out.print(mark);
			}
			System.out.println(msg1[i]);
		}
		printMsg(cnt + 1);
		printMark(cnt);
		System.out.println("라고 답변하였지.");
	}
	
	static void printMark(int n) {
		for (int j = 0; j < n; j++) {
			System.out.print(mark);
		}
	}
}
