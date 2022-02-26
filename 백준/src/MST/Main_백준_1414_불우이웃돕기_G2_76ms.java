package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1414_불우이웃돕기_G2_76ms {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] d = new int[N][N];
		int[] minEdge = new int[N];
		
		int[] num = new int['z' + 1];
		int start = 'A' - 1;
		for (int i = 1; i <= 26; i++) {
			num[start + i] = i + 26;
		}
		start = 'a' - 1;
		for (int i = 1; i <= 26; i++) {
			num[start + i] = i;
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				int n = num[line.charAt(j)];
				if (n == 0)
					continue;
				if (d[i][j] == 0)
					d[i][j] = n;
				else
					d[i][j] = d[i][j] > n ? n : d[i][j];					
				if (d[j][i] == 0)
					d[j][i] = n;
				else
					d[j][i] = d[j][i] > n ? n : d[j][i];
				sum += n;
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		minEdge[0] = 0;
		boolean[] visited = new boolean[N];
		
		for (int c = 0; c < N; c++) {
			int min = Integer.MAX_VALUE;
			int minV = 0;
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minV = i;
					flag = true;
				}
			}
			if (!flag) {
				System.out.println(-1);
				return;
			}
			
			visited[minV] = true;
			sum -= min;
			
			for (int i = 0; i < N; i++) {
				if (!visited[i] && d[minV][i] != 0 && d[minV][i] < minEdge[i])
					minEdge[i] = d[minV][i];
			}
		}
		System.out.println(sum);
	}//end main
}//end class

/*
 * 입력으로 인접행렬 만듬, 입력 가중치 값 다 합해놓음, i -> j의 랜선과 j -> i랜선 중 최소값을 행렬에 저장
 * 최소 신장 트리로 만들어진 가중치를 뺀 값이 정답임
 * 
 * */
