package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1158_요세푸스문제_140ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			num.add(i);
		}
		
		int idx = K - 1;
		sb.append("<").append(num.remove(idx));
		N--;
		while (!num.isEmpty()) {
			sb.append(", ");
			idx += K - 1;
			if (idx >= N)
				idx %= N;
			N--;
			sb.append(num.remove(idx));
		}
		sb.append(">\n");
		System.out.print(sb.toString());
	}//end main
}
/*
 * 자료구조를 큐로 하지 않고, arrayList로 하면 더 빠르게 가능
 * k-1개를 빼고 넣는 작업 없이 바로 인덱스로 접근해서 값 얻고, 인덱스 값 삭제하는 방식 가능
 *  0 1 2 3 4 5 6
 *
 * */
