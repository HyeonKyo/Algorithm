package Set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_김현교_299ms {
	
	static int N;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		makeSet();
		int M = Integer.parseInt(st.nextToken());
		int cnt = N;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (union(a, b))
				cnt--;
		}
		System.out.println(cnt);
	}//end main

	static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br)
			return false;
		parent[br] = ar;
		return true;
	}
}

