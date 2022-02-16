package Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2775_부녀회장이될테야 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int n = 0;
		int k = 0;
		for (int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			k++;
			int j = 0;
			int[][] a = new int[k][n];
			for (j = 0; j < n; j++) {
				a[0][j] = j + 1;
			}
			for (int l = 1; l < k; l++) {
				int sum = 0;
				for (j = 0; j < n; j++) {
					a[l][j] = sum + a[l - 1][j];
					sum += a[l - 1][j];
				}
			}
			System.out.println(a[k - 1][n - 1]);
		}
	}
}
