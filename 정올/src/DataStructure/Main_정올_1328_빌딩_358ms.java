package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_1328_빌딩_358ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] h = new int[N];
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(br.readLine());
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

/*
6
3
2
6
1
1
2
 * */
