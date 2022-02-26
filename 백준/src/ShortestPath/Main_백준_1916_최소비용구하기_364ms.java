package ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1916_최소비용구하기_364ms {

	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] list = new Node[N + 1];
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (list[from] == null)
				list[from] = new Node(to, w, null);
			else {
				Node tmp = list[from];
				list[from] = new Node(to, w, tmp);
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pq.offer(new Vertex(start, distance[start]));
		boolean[] v = new boolean[N + 1]; 
		
		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();
			if (v[cur.no])
				continue;
			v[cur.no] = true;
			if (cur.no == end)
				break;
			
			Node n = list[cur.no];
			while (n != null) {
				int nextVertex = n.to;
				if (distance[nextVertex] > distance[cur.no] + n.w) {
					distance[nextVertex] = distance[cur.no] + n.w;
					pq.offer(new Vertex(nextVertex, distance[nextVertex]));
				}
				n = n.next;
			}
		}
		System.out.println(distance[end]);
	}//end main
		
	static class Node {
		int to, w;
		Node next;
		
		public Node(int to, int w, Node next) {
			super();
			this.to = to;
			this.w = w;
			this.next = next;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no, distance;
		
		public Vertex(int no, int distance) {
			super();
			this.no = no;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			return distance - o.distance;
		}
	}
}//end class


