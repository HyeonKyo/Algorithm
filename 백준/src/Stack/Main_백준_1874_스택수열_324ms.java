package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1874_스택수열_324ms {
	
	static int[] st;
	static int size;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		st = new int[n];
		int num = 1;
		
		for (int i = 0; i < n; i++) {
			int getNum = Integer.parseInt(br.readLine());
			while (num <= getNum)
				push(num++);
			boolean find = false;
			while (size > 0) {
				int tmp = pop();
				if (tmp == getNum) {
					find = true;
					break;
				}
			}
			if (!find) {
				System.out.println("NO");
				return;
			}
		}
		System.out.print(sb.toString());
	}//end main
	
	static void push(int n) {
		st[size++] = n;
		sb.append("+\n");
	}
	
	static int pop() {
		sb.append("-\n");
		return st[--size];
	}
}//end class

/*
 * push, pop함수 만들기 sb에 기호 넣는 것까지
 * 1. getnum보다 큰 num까지 push
 * 2. getnum찾을때까지 pop
 * 3. 만약 size가 0일때까지 찾지 못하면 No
 * 
 * */
