package DFS_BFS;

import java.io.BufferedReader;	
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1697_숨바꼭질_136ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[200001];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int t = 0;
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				int cur = q.poll();
				
				if (cur == K) {
					System.out.println(t);
					return;
				}
				if (cur * 2 < 2 * K && !v[cur * 2]) {
					q.add(cur * 2);
					v[cur * 2] = true;
				}
				if (cur + 1 < 2 * K && !v[cur + 1]) {
					q.add(cur + 1);
					v[cur + 1] = true;
				}
				if (cur - 1 >= 0 && !v[cur - 1]) {
					q.add(cur - 1);
					v[cur - 1] = true;
				}
			}
			t++;
		}
	}
}//end class