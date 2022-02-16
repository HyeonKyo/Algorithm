package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14890_경사로 {
	
	static int N;
	static int L;
	static int[][] m;
	static int avail;
	static final int LEFT = 0;
	static final int RIGHT = 1;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		m = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			checkRow(i);
			checkCol(i);
		}
		System.out.println(avail);
	}//end main
	
	static void checkRow(int idx) {
		int[] arr = m[idx];
		
		int num = arr[0];
		int cnt = 1;
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (flag && cnt >= L) {
				flag = false;
				cnt = 0;
			}
			if (i >= N)
				break;
			if (arr[i] == num) {
				cnt++;
				continue;
			}
			if (flag || (arr[i] > num && cnt < L))
				return;
			else if (arr[i] < num)
				flag = true;
			num = arr[i];
			cnt = 1;
		}
		if (!flag)
			avail++;
	}
	
	static void checkCol(int idx) {
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = m[i][idx];
		}
		int num = arr[0];
		int cnt = 1;
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (flag && cnt >= L) {
				flag = false;
				cnt = 0;
			}
			if (i >= N)
				break;
			if (arr[i] == num) {
				cnt++;
				continue;
			}
			if (flag || (arr[i] > num && cnt < L))
				return;
			else if (arr[i] < num)
				flag = true;
			num = arr[i];
			cnt = 1;
		}
		if (!flag)
			avail++;
	}
}

