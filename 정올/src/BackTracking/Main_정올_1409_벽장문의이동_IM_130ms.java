package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1409_벽장문의이동_IM_130ms {
	
	static int inCount, target[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int o1 = Integer.parseInt(st.nextToken());
		int o2 = Integer.parseInt(st.nextToken());
		
		inCount = Integer.parseInt(br.readLine());
		target = new int[inCount];
		for (int i = 0; i < inCount; i++) {
			target[i]  = Integer.parseInt(br.readLine());
		}
		
		System.out.println(find(0, o1, o2));
	}//end main
	
	static int find(int cnt, int o1, int o2) {
		
		if (cnt == inCount)
			return 0;
		
		int d1 = Math.abs(target[cnt] - o1);
		int d2 = Math.abs(target[cnt] - o2);
		
		return Math.min(d1 + find(cnt + 1, target[cnt], o2),
				d2 + find(cnt + 1, o1, target[cnt]));
	}
}
