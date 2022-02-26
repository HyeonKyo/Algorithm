package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1183_동전자판기_IM_114ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] coin = {500, 100, 50, 10, 5, 1};
		int[] coinCnt = new int[6];
		for (int i = 0; i < 6; i++) {
			coinCnt[i] = Integer.parseInt(st.nextToken());
		}
		int[] ans = new int[6];
		int sum = 0;
		for (int i = 5; i >= 1; i--) {
			int curPrice = coin[i];
			int prePrice = coin[i - 1];
			ans[i] = coinCnt[i];
			while ((w - (ans[i] * curPrice)) % prePrice != 0)
				ans[i]--;
			w -= ans[i] * curPrice;
			sum += ans[i];
			if (w == 0)
				break;
		}
		if (w > 0) {
			ans[0] = coinCnt[0];
			while (w - coin[0] * ans[0] != 0)
				ans[0]--;
			sum += ans[0];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n");
		for (int i = 0; i < 6; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb.toString());
	}//end main
}
//뒤의 동전부터 최대로 넣고, 앞의 동전 배수가 될때까지 하나씩 뺌