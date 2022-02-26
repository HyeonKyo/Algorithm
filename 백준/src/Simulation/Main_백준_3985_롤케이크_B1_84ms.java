package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_3985_롤케이크_B1_84ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] ck = new boolean[L + 1];
		int preMax = 0;
		int preMaxPerson = 0;
		int max = 0;
		int maxPerson = 0;
		int[] cakeCnt = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (r - l > preMax) {
				preMax = r - l;
				preMaxPerson = i;
			}
			for (int j = l; j <= r; j++) {
				if (!ck[j]) {
					ck[j] = true;
					cakeCnt[i]++;
				}
			}
			if (max < cakeCnt[i]) {
				max = cakeCnt[i];
				maxPerson = i;
			}
		}
		System.out.println(preMaxPerson + "\n" + maxPerson);
	}//end main
}