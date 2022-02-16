package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_5430_AC {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			String func = br.readLine();
			int len = Integer.parseInt(br.readLine());
			int[] arr = parse(br.readLine(), len);
			
			int left = 0;
			int right = len - 1;
			if (right < 0)
				right = 0;
			int direction = 1;
			boolean error = false;
			
			for (int i = 0; i < func.length(); i++) {
				switch (func.charAt(i)) {
				case 'R':
					direction *= -1;
					break;
				case 'D':
					if (direction > 0)
						left++;
					else
						right--;
				}
				if (left > right) {
					error = true;
					break;
				}
			}
			if (error)
				sb.append("error\n");
			else if (len == 0)
				sb.append("[]\n");
			else {
				sb.append("[");
				int start = direction > 0 ? left : right;
				int last = direction > 0 ? right : left;
				int end = last + direction;
				for (int i = start; i != end; i += direction) {
					sb.append(arr[i]).append(",");
				}
				sb.setLength(sb.length() - 1);
				sb.append("]\n");
			}
		}
		System.out.print(sb.toString());
	}//end main
	
	static int[] parse(String s, int len) {
		int[] arr = new int[len];
		if (len <= 0)
			return arr;
		int num = 0;
		for (int i = 1, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');
			} else {
				arr[j++] = num;
				num = 0;
			}
		}
		return arr;
	}
}//end class