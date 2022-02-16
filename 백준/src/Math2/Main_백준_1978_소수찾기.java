package Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(s.nextToken());
			if (n <= 1)
				continue;
			boolean flag = true;
			for (int j = 2; j * j <= n; j++) {
				if (n % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				cnt++;
		}
		System.out.println(cnt);
	}
}
