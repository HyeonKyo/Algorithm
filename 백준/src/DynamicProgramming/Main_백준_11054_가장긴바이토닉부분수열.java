package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_11054_가장긴바이토닉부분수열 {

	static int[] fw;//forward
	static int[] rv;//reverse
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		fw = new int[n];
		rv = new int[n];
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		fw[0] = 1;
		for (int i = 1; i < n; i++) {
			fw[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && fw[i] < fw[j] + 1) {
					fw[i] = fw[j] + 1;
				}
			}
		}
		
		rv[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			rv[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (arr[j] < arr[i] && rv[i] < rv[j] + 1) {
					rv[i] = rv[j] + 1;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			fw[i] += rv[i] - 1;
		}
		Arrays.sort(fw);
		System.out.println(fw[n - 1]);
	}
}
