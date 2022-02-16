package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_9663_NQueen {
	static int N;
	static int[] arr;
	static boolean[] ck;
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		ck = new boolean[N];
		
		back(0);
		System.out.println(cnt);
	}//end of main
	
	static void back(int T) {
		if (T >= N) {
			cnt++;
			return ;
		}
		
		int i = 0;
		int j = 0;
		boolean flag;
		for (i = 0; i < N; i++) {
			flag = true;
			for (j = 1; j <= T; j++) {
				if (ck[i] == true || arr[T - j] == i - j || arr[T - j] == i + j)
				{
					flag = false;
					break ;
				}
			}
			if (flag) {
				arr[T] = i;
				ck[i] = true;
				back(T + 1);
				ck[i] = false;
			}
		}
	}
}//end of class

//T��° ���� ��ġ�� �� ��������(0~N-1����)
//���� �� if�� �˻� -> �밢���� ��ġ�Ѱ� �ִ���
//�밢�� �˻�� j�� 1~T����
//arr[T -j]�� ������ i - j�� ���� �ʰ�,
//i + j�� ���� ���� ���̴�.
