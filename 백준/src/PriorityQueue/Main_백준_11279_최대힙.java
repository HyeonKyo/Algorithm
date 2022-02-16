package PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_11279_최대힙 {
	
	static int N;
	static int[] heap;
	static int cur = 1;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		heap = new int[N + 1];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			switch (line) {
			case "0":
				sb.append(pop()).append("\n");
				break;
			default:
				add(Integer.parseInt(line));
				break;
			}
		}
		System.out.print(sb.toString());
		
	}//end main
	static void add(int n) {
		heap[cur] = n;
		int c = cur;
		int p = cur / 2;
		while (p > 0 && heap[c] > heap[p]) {
			heap[c] = heap[p];
			heap[p] = n;
			c = p;
			p = c / 2;
		}
		cur++;
	}
	
	static int pop() {
		if (cur == 1)
			return 0;
		int ret = heap[1];
		heap[1] = heap[--cur];
		int p = 1;
		int c1 = p * 2;
		int c2 = p * 2 + 1;
		int c = heap[c1] >= heap[c2] ? c1 : c2;
		while (c < cur && heap[c] > heap[p]) {
			int tmp = heap[p];
			heap[p] = heap[c];
			heap[c] = tmp;
			p = c;
			c1 = p * 2;
			c2 = p * 2 + 1;
			if (c2 >= cur)
				c = c1;
			else
				c = heap[c1] >= heap[c2] ? c1 : c2;
		}
		return ret;
	}
}
