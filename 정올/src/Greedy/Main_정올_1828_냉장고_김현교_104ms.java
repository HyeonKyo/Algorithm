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
		//최저 온도로 오름차순 정렬
		Arrays.sort(t);

		int result = 1;//냉장고 개수 카운트
		//최저 온도로 정렬된 온도를 하나씩 보면서
		//현재 냉장고 기준 온도를 최대 온도로 잡고
		//현재 화학물질의 최소온도가 기준온도보다 낮으면 같은 냉장고 사용 가능
		//(기준 온도는 두 화학 물질의 최대 온도 중 더 작은 값으로 변경)
		//그게 아니면 냉장고 1대 더 늘리고, 기준 온도를 현재 물질 최대 온도로 변경
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
		
		//최저 온도로 오름차순 정렬
		@Override
		public int compareTo(Temp o) {
			return this.min - o.min;
		}
	}
}//end class