package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_10773_제로 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				s.pop();
			else
				s.push(num);
		}
		int sum = 0;
		while (!s.isEmpty()) {
			sum += s.pop();
		}
		System.out.print(sum);
	}
}
