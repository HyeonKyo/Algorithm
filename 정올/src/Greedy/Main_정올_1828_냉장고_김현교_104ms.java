package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_김현교_104ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Temp[] t = new Temp[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(t);

		int result = 1;
		int maxTemp = t[0].max;
		for (int i = 1; i < N; i++) {
			if (t[i].min > maxTemp) {
				result++;
				maxTemp = t[i].max;
			} else {
				maxTemp = Math.min(t[i].max, maxTemp);
			}
		}
		System.out.println(result);
	}//end main
	
	static class Temp implements Comparable<Temp> {
		int min, max;

		public Temp(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		
		@Override
		public int compareTo(Temp o) {
			return this.min - o.min;
		}
	}
}//end class