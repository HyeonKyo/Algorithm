package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크 {
	
	static int N;
	static int map[][];
	static boolean isLink[];
	static int min = 2147483647;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isLink = new boolean[N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0, 0);
		System.out.println(min);
	}
	
	//�� ������ ��ͷ�, ���� ���¸� boolean�迭�� ǥ��
	static void combi(int idx, int cnt) {
		if (cnt == N / 2) {
			diff();
			return ;
		}
		
		for (int i = idx; i < N; i++) {
			if (!isLink[i]) {
				isLink[i] = true;
				combi(i + 1, cnt + 1);
				isLink[i] = false;
			}
		}
	}
	
	//����� ���� �� ����ǰ�, ��ͷ� ���յ� ���� �ɷ�ġ ���̸� ���ؼ� min�� ����
	//min�� 0�̸� ���̻� ������ �ʿ� ����.
	static void diff() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (isLink[i] && isLink[j])
					link += map[i][j] + map[j][i];
				else if (!isLink[i] && !isLink[j])
					start += map[i][j] + map[j][i];
			}
		}
		
		min = Math.min(min, Math.abs(start - link));
		if (min == 0) {
			System.out.println(0);
			System.exit(0);
		}
	}
}
