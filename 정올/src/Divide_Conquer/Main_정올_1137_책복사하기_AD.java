package Divide_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1137_책복사하기_AD {
	
	static int m, k, base, sum, max, maxIdx;
	static int[] b, pv, sumArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			b = new int[m];
			st = new StringTokenizer(br.readLine(), " ");
			base = 0;
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
				base += b[i];
			}
			base /= k;
			
			//피봇 정하기
			sumArr = new int[k];
			max = 0;
			pv = new int[k + 1];
			pv[0] = 0;
			pv[k] = m;
			for (int i = 1; i < k; i++) {
				pv[i] = pv[i - 1] + 1;
				sum = b[pv[i - 1]];
				if (b[pv[i - 1]] < base)//트롤체크
					find(i - 1, i, 0);
				sumArr[i - 1] = sum;
				if (max < sum) {
					max = sum;
					maxIdx = i;
				}
			}
			
			for (int i = 1; i < k; i++) {
				if (i == maxIdx)
					break;
				while (pv[i] > i && sumArr[i] + pv[i] <= max) {
//					sumArr[i] += pv[i];
//					sumArr[i - 1] -= pv[i];
					pv[i]--;
				}
			}
			
			for (int i = 0, j = 1; i < m; i++) {
				if (i == pv[j]) {
					sb.append("/").append(" ");
					j++;
				}
				sb.append(b[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}//end main
	
	static void find(int start, int end, int preSum) {
		
		int si = pv[start];
		int ei = pv[end];
		sum = 0;
		for (int i = si; i < ei; i++) {
			sum += b[i];
		}
//		System.out.printf("start, end : %d %d\n", start, end);
//		System.out.printf("sidx, eidx : %d %d\n", si, ei);
//		System.out.printf("base %d / sum preSum : %d %d\n",base, sum, preSum);
		if (sum == base)
			return;
		if (Math.abs(sum - base) >= Math.abs(preSum - base)) {
			pv[end]--;
//			System.out.printf("[end : %d, pv[end] : %d]\n", end, pv[end]);
			return;
		}
		
		if (pv[end] >= m - (k - end))
			return;
		pv[end]++;
		
		find(start, end, sum);
	}
}

/*
 * 앞에서부터 범위를 추 하나씩 늘려가면서 base와 추 합의 거리가 커지는 경우까지 범위 늘려감
 * 최대 범위 도달하는 예외 경우도 있음
 * 그렇게 합을 구하면서 sum값을 각각 비교하며 각 구간의 maxSum값을 구해놓음
 * 첫단락부터 end를 하나씩 줄여가도 maxSum이 계속 max이면 가능한것
 * 두번째 단락도 실시
 * 
 * */
