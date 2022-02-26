package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_10026_적록색약_88ms {

	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	static int N, cnt1, cnt2;
	static Queue<int[]> q = new LinkedList<>();
	static char[][] m;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		//1.입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		m = new char[N][];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			m[i] = br.readLine().toCharArray();
		}
		
		cnt1 = 0;
		cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j])
					continue;
				cnt1++;//정상인 사람
				cnt2++;//색약인 사람
				search(i, j, m[i][j]);
				while (!q.isEmpty()) {
					int[] tmp = q.poll();
					if (!v[tmp[0]][tmp[1]]) {
						cnt1++;
						search(tmp[0], tmp[1], (char)tmp[2]);
					}
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}//end main
	
	static void search(int l, int r, char base) {
		
		if (m[l][r] != base) {
			if ((base == 'R' || base == 'G') && (m[l][r] == 'R' || m[l][r] == 'G')) {
				q.offer(new int[] {l, r, m[l][r]});
			}
			return;
		}
		
		v[l][r] = true;
		
		for (int i = 0; i < 4; i++) {
			int il = l + dl[i];
			int ir = r + dr[i];
			if (il < 0 || il >= N || ir < 0 || ir >= N || v[il][ir])
				continue;
			search(il, ir, base);
		}
	}
}//end class
//search하는 base와 다른 문자가 R,G이면 색약인 사람은 계속 탐색을 할 것임
//바로 search하지 않고 큐에 넣는 이유는
//정상 상태의 탐색을 다 마치고 색약인 사람의 탐색을 시작하기 위해 임시 저장해놓은 것임.
