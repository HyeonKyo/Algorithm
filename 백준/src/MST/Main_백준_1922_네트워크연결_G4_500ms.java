package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_1922_네트워크연결_G4_500ms {

	static int[] p;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Edge> l = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l.add(new Edge(Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken())));
		}
		Collections.sort(l);
		
		makeSet();
		int cost = 0;
		int cnt = 0;
		for (Edge edge : l) {
			if (union(edge.from, edge.to)) {
				cost += edge.w;
				if (++cnt == N - 1)
					break;
			}
		}
		System.out.println(cost);
	}//end main
	
	static void makeSet() {
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
	
	static int findSet(int n) {
		if (p[n] == n)
			return n;
		return p[n] = findSet(p[n]);
	}
	
	static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br)
			return false;
		p[br] = ar;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to, w;

		public Edge(int from, int to, int w) {
			super();
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

