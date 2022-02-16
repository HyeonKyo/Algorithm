package Divide_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main_백준_1074_Z_김현교_124ms {
	
	static int N, r, c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int x = 0;
		while (c > 0) {
			int cnt = 0;
			int n = 2;
			while (c >= n) {
				n *= 2;
				cnt++;
			}
			c -= Math.pow(2, cnt);
			x += Math.pow(2, 2 * cnt);
		}
		int y = 0;
		while (r > 0) {
			int cnt = 0;
			int n = 2;
			while (r >= n) {
				n *= 2;
				cnt++;
			}
			r -= Math.pow(2, cnt);
			y += 2 * Math.pow(2, 2 * cnt);
		}
		System.out.println(x + y);
	}//end main
	
}//end class