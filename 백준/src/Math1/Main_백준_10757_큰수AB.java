package Math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10757_큰수AB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		String a = s.nextToken();
		String b = s.nextToken();
		
		int len = Math.max(a.length(), b.length());
		int[] arr1 = new int[len + 1];
		int[] arr2 = new int[len + 1];
		
		int i = 0;
		for ( ; i < a.length(); i++) {
			arr1[i] = a.charAt(a.length() - 1 - i) - '0';
		}
		for (i = 0; i < b.length(); i++) {
			arr2[i] = b.charAt(b.length() - 1 - i) - '0';
		}
		int val = 0;
		for (i = 0; i < len; i++) {
			val = arr1[i] + arr2[i];
			arr1[i] = val % 10;
			arr1[i + 1] += val / 10;
		}
		StringBuilder sb = new StringBuilder();
		if (arr1[len] != 0)
			sb.append(arr1[len]);
		for (i = len - 1; i >= 0; i--) {
			sb.append(arr1[i]);
		}
		System.out.println(sb);
	}
}
