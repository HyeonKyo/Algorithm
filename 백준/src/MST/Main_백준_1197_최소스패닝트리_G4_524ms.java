package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_1197_최소스패닝트리_G4_524ms {

	static int[] p;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge> list = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(from, to, w));
		}
		Collections.sort(list);
		
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		long result = 0;
		int cnt = 0;//간선수
		for (Edge edge : list) {
			if (union(edge.from, edge.to)) {
				result += edge.w;
				if (++cnt == V - 1)
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
/*
4 5
2 4 5
2 3 2
1 3 3
3 4 5
1 2 1
 */

