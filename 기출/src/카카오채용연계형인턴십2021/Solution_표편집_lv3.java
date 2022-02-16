package 카카오채용연계형인턴십2021;

public class Solution_표편집_lv3 {
	
	public static void main(String[] args) {
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		System.out.println(solution(8, 2, cmd));
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(8, 2, cmd2));
		
	}
	
	static public String solution(int n, int k, String[] cmd) {
		boolean[] ck = new boolean[n + 1];
		int[] stack = new int[n];
		int cur = 0;
		int size = n;
		for (String c : cmd) {
			switch (c) {
			case "C":
				if (n == 0)
					break;
				ck[k] = true;
				stack[cur++] = k;
				while (ck[++k])
					;
				if (k >= size) {
					k = stack[cur - 1] - 1;
					while (k > 0 && ck[k])
						k--;
				}
				n--;
				break;
			case "Z":
				int num = stack[--cur];
				ck[num] = false;
				if (n == 0)
					k = num;
				n++;
				break;
			default :
				if (n <= 1)
					break;
				int inc = c.charAt(0) == 'U' ? -1 : 1;
				int len = Integer.parseInt(c.substring(2));
				while (len > 0) {
					if (k >= size - 1 || k <= 0)
						break;
					k += inc;
					if (ck[k])
						continue;
					len--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(ck[i] ? 'X' : 'O');
		}
		return sb.toString();
	}
}//end class
