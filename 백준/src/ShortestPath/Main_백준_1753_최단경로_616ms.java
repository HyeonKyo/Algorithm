package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1753_최단경로_616ms {

	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		Node[] list = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (list[u] == null) 
				list[u] = new Node(v, w, null);
			else {
				Node n = new Node(v, w, null);
				n.link = list[u];
				list[u] = n;
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] distance = new int[V + 1];
		boolean[] v = new boolean[V + 1];
		Arrays.fill(distance, MAX);
		distance[K] = 0;
		pq.offer(new Edge(K, 0));
		
		while (!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int cur = tmp.v;
			
			if (v[cur])
				continue;
			v[cur] = true;
			
			Node n = list[cur];
			while (n != null) {
				int to = n.to;
				if (distance[to] > distance[cur] + n.w) {
					distance[to] = distance[cur] + n.w;
					pq.offer(new Edge(to, distance[to]));
				}
				n = n.link;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(!v[i] ? "INF" : distance[i]).append("\n");
		}
		System.out.print(sb.toString());
	}//end main
	
	static class Node {
		int to, w;
		Node link;
		
		public Node(int to, int w, Node link) {
			super();
			this.to = to;
			this.w = w;
			this.link = link;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int v, d;

		public Edge(int v, int d) {
			super();
			this.v = v;
			this.d = d;
		}
		
		@Override
		public int compareTo(Edge o) {
			return d - o.d;
		}
	}
}//end class

/*
10 17
1
1 2 5
1 3 7
2 4 10
2 5 9
3 2 4
3 5 3
3 6 4
4 7 7
5 4 3
5 6 2
5 7 4
5 8 8
6 8 5
6 9 9
7 10 14
8 10 10
9 10 5

output ==> 21
 * 
 * */

