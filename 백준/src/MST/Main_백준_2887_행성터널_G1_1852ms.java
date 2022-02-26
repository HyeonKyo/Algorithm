package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 틀린 이유 : 메모리 초과
 * 	N이 최대 100000개이므로 간선 개수가 100000!(?)정도 -> 어마무시하게 많은 간선리스트
 * 
 * 이번 문제의 가중치는 x좌표끼리의 차 or y좌표끼리의 차 or z좌표끼리의 차 중 최소이다.
 * 즉 x로 정렬해서 인접한 점끼리의 거리만 구하고, y,z도 동일하게 처리한 뒤
 * 그 거리들로만 가중치 정렬시키면 된다.
 * (각각의 좌표들은 1차원이므로 정렬한 뒤 인접한 것이 최소 거리(가중치)값이 됨)
 * 이렇게 하면 3(N - 1)의 공간 복잡도이므로 허용가능이다.
 * 
 * */
public class Main_백준_2887_행성터널_G1_1852ms {

	static int N;
	static int[] p;
	static List<Edge> edgeList;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//1. 포인트들 저장
		Point[] p = new Point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new Point(i, Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()));
		}
		//2. 포인트의 x,y,z로 정렬 후 인접값끼리로 인접리스트 만들기
		makeEdgeList(p);
		//3. kruskal
		makeSet();
		int res = 0;
		int cnt = 0;
		for (Edge e : edgeList) {
			if (union(e.from, e.to)) {
				cnt++;
				res += e.dist;
				if (cnt == N - 1)
					break;
			}
		}
		System.out.println(res);
	}//end main

	private static void makeEdgeList(Point[] p) {
		edgeList = new LinkedList<>();
		Arrays.sort(p, (p1, p2) -> {
			return p1.x - p2.x;
		});
		for (int i = 1; i < N; i++) {
			int from = p[i - 1].no;
			int to = p[i].no;
			int dist = p[i].x - p[i - 1].x;
			edgeList.add(new Edge(from, to, dist));
		}
		
		Arrays.sort(p, (p1, p2) -> {
			return p1.y - p2.y;
		});
		for (int i = 1; i < N; i++) {
			int from = p[i - 1].no;
			int to = p[i].no;
			int dist = p[i].y - p[i - 1].y;
			edgeList.add(new Edge(from, to, dist));
		}
		
		Arrays.sort(p, (p1, p2) -> {
			return p1.z - p2.z;
		});
		for (int i = 1; i < N; i++) {
			int from = p[i - 1].no;
			int to = p[i].no;
			int dist = p[i].z - p[i - 1].z;
			edgeList.add(new Edge(from, to, dist));
		}
		Collections.sort(edgeList);
	}
	
	static void makeSet() {
		p = new int[N];
		for (int i = 0; i < N; i++) {
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
	
	static class Point {
		int no, x, y, z;

		public Point(int no, int x, int y, int z) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to, dist;

		public Edge(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return dist - o.dist;
		}
	}
}//end class

