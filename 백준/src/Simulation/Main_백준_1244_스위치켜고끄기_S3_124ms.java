package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1244_스위치켜고끄기_S3_124ms {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		boolean[] s = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = st.nextToken().equals("1") ? true : false;
		}
		int p = Integer.parseInt(br.readLine());
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			switch (tmp) {
			case "1":
				int idx = n - 1;
				while (idx < N) {
					s[idx] ^= true;
					idx += n;
				}
				break;
			case "2":
				s[n - 1] ^= true;
				int il = n - 2;
				int ir = n;
				while (il >= 0 && ir < N && s[il] == s[ir]) {
					s[il--] ^= true;
					s[ir++] ^= true;
				}
				break;
			}
		}
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i] ? 1 : 0).append(" ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}
		if (sb.charAt(sb.length() - 1) != '\n')
			sb.append("\n");
		System.out.print(sb.toString());
	}//end main
}