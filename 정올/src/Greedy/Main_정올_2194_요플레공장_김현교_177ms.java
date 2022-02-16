package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2194_요플레공장_김현교_177ms {
	
	static int N, S;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int price = Integer.parseInt(st.nextToken());
		long sum = price * Integer.parseInt(st.nextToken());
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int nextP = Integer.parseInt(st.nextToken());
			int nextA = Integer.parseInt(st.nextToken());
			if (nextP > price + (S * cnt)) {
				sum += (price + (S * cnt)) * nextA;
				cnt++;
			} else {
				sum += nextP * nextA;
				price = nextP;
				cnt = 1;
			}
		}
		System.out.println(sum);
	}//end main
}//end class

/*
 * 현재에서 다음 a주의 가격 확인 -> 그 가격이 5*a보다 크다면 그 개수까지 포함해서 구매 
 * 
 * 
 * 
 * */
