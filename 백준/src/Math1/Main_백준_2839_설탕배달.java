package Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2839_설탕배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		while (N > 5 * x)
			x++;
		if (N == 5 * x) {
			System.out.println(x);
			return ;
		}
		while (--x >= 0) {
			if ((N - 5 * x) % 3 == 0)
			{
				y = (N - 5 * x) / 3; 
				System.out.println(x + y);
				return ;
			}
		}
		System.out.println(-1);
	}
}
