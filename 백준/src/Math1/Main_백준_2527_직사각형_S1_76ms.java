package Math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2527_직사각형_S1_76ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Square[] s = new Square[2];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s[0] = new Square(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			s[1] = new Square(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			Arrays.sort(s);
			
			if (s[0].p < s[1].x || s[0].q < s[1].y || s[0].y > s[1].q) {
				//아예 떨어진 경우
				sb.append("d\n");
			} else if (s[0].p == s[1].x) {//x위치가 하나 겹칠때
				if (s[0].q == s[1].y || s[0].y == s[1].q) {
					//y위치도 하나 겹치면 점인 경우
					sb.append("c\n");
				} else if ((s[1].y <= s[0].q && s[0].q <= s[1].q)
						|| (s[1].y <= s[0].y && s[0].y <= s[1].q)
						|| (s[1].q <= s[0].q && s[1].y >= s[0].y)
						|| (s[0].q <= s[1].q && s[0].y >= s[1].y)) {
					//y위치가 사이에 있는 경우-> 선분
					sb.append("b\n");
				}
			} else { //x위치가 아예 겹칠 떄
				//1.y위치가 경계면 선분
				//2.나머지는 직사각형
				if (s[0].q == s[1].y || s[0].y == s[1].q)
					sb.append("b\n");
				else
					sb.append("a\n");
			}
		}
		System.out.print(sb.toString());
	}//end main

	static class Square implements Comparable<Square> {
		int x, y, p, q;

		public Square(int x, int y, int p, int q) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
		
		@Override
		public int compareTo(Square o) {
			if (this.x == o.x)
				return this.p - o.p;
			return this.x - o.x;
		}
	}
}
/*
5022 32934 47485 42083 23481 29623 34153 32923
414 10 3000 300 4 7 414 411
1523 11672 5605 46369 733 1103 46267 9060
23947 43538 44990 44434 6187 27973 39632 49082
 * 
 * 
 * */
