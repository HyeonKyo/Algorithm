package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1214_히스토그램_xms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] h = new int[N];
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] stackH = new int[N];
		int[] stackI = new int[N];
		int size = 0;
		for (int i = N - 1; i >= 0; i--) {
			int num = h[i];
			while (size > 0 && stackH[size - 1] <= num)
				size--;
			if (size > 0 && stackH[size - 1] > num)
				h[i] = stackI[size - 1];
			else
				h[i] = 0;
			stackH[size] = num;
			stackI[size++] = i + 1;
		}
		for (int i : h) {
			sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}//end main
}//end class