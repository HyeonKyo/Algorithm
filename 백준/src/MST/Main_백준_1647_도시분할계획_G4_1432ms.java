package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_1647_도시분할계획_G4_1432ms {

	static int[] p;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Edge> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(from, to, w));
		}
		Collections.sort(list);
		
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		int result = 0;//유지비
		int cnt = 0;//간선수
		for (Edge edge : list) {
			if (union(edge.from, edge.to)) {
				result += edge.w;
				if (++cnt == N - 2)//간선이 N - 1개에서 하나를 빼면 마을 두개
					break;
			}
		}
		System.out.println(result);
	}//end main
	
	static int findSet(int n) {
		if (p[n] == n)
			return n;
		return p[n] = findSet(p[n]);
	}
	
	static boolean union(int a, int b) {
		int ar = findSet(p[a]);
		int br = findSet(p[b]);
		if (ar == br)
			return false;
		p[br] = ar;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to, w;

		public Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return w - o.w;
		}
	}
}//end class


