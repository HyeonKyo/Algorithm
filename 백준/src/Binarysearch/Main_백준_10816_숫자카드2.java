package Binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_10816_숫자카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		for (; i < n; i++)
			num[i] = Integer.valueOf(st.nextToken());
		Arrays.sort(num);
		int m = Integer.parseInt(br.readLine());
		int[] find = new int[m];
		st = new StringTokenizer(br.readLine());
		for (i = 0; i < m; i++)
			find[i] = Integer.valueOf(st.nextToken());
		
		
		i = 0;
		StringBuilder sb = new StringBuilder();
		//나중에 다시
	}
	
	static int lowerBound(int[] num, int key) {
		int pl = 0;
		int pr = num.length;
		int mid = 0;
		while (pl < pr) {
			mid = (pl + pr) / 2;
			if (key <= num[mid])
				pr = mid;
			else
				pl = mid + 1;
		}
		return (pl);
	}
	
	static int upperBound(int[] num, int key) {
		int pl = 0;
		int pr = num.length;
		int mid = 0;
		while (pl < pr) {
			mid = (pl + pr) / 2;
			if (key < num[mid])
				pr = mid;
			else
				pl = mid + 1;
		}
		return (pl);
	}
}
