package NumberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_5086_배수와약수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.valueOf(st.nextToken());
			int M = Integer.valueOf(st.nextToken());
			
			if (N == 0 && M == 0)
				return ;
			if (M % N == 0) {
				System.out.println("factor");
			} else if (N % M == 0) {
				System.out.println("multiple");
			} else 
				System.out.println("neither");
		}
	}
}
