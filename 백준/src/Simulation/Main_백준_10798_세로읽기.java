package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10798_세로읽기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = new char[75];
		
		for (int i = 0; i < 5; i++) {
			String tmp = br.readLine();
			int start = 15 * i;
			int size = tmp.length();
			for (int j = 0; j < 15; j++) {
				arr[start + j] = j < size ? tmp.charAt(j) : (char)0; 
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				char c = arr[15 * j + i];
				if (c != 0)
					sb.append(c);
			}
		}
		System.out.println(sb);
	}//end main
}//end class
