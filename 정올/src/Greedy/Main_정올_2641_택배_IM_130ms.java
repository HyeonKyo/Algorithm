package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_정올_2641_택배_IM_130ms {
	
	static int N, C, M, info[][], ans, capacity[];
	static final int SEND = 0, TAKE = 1, NUM = 2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		info = new int[M][3];
		capacity = new int[N + 1];
		Arrays.fill(capacity, C);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][SEND] = Integer.parseInt(st.nextToken());
			info[i][TAKE] = Integer.parseInt(st.nextToken());
			info[i][NUM] = Integer.parseInt(st.nextToken());
		}
		//1. 받는 도시 오름차순 정렬 (같으면 보내는 도시 오름차순)
		Arrays.sort(info, (o1, o2) -> {
			if (o1[TAKE] == o2[TAKE])
				return o1[SEND] - o2[SEND];
			return o1[TAKE] - o2[TAKE];
		});
		
		for (int i = 0; i < M; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = info[i][SEND]; j < info[i][TAKE]; j++) {
				if (capacity[j] < min)
					min = capacity[j];
			}
			int tmp = Math.min(info[i][NUM], min);
			for (int j = info[i][SEND]; j < info[i][TAKE]; j++) {
				capacity[j] -= tmp;
			}
			ans += tmp;
		}
		System.out.println(ans);
	}//end main
}
