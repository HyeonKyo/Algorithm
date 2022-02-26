package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1038_감소하는수_김현교_G5_88ms {

	static int N;
	static int[] max = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if (N <= 10) {
			System.out.println(N);
			return;
		}
		int num = 11;
		int len = 2;
		int[] ans = new int[11];//여유공간 하나 두기
		ans[0] = 0;
		ans[1] = 2;//20
		while (true) {
			//N번째 값 찾은 경우 ans출력
			if (num >= N) {
				break;
			}
			
			//max값보다 큰 경우 -1출력 후 종료
			if (len == 10) {
				int idx = 0;
				while (idx < 10 && max[idx] == ans[idx])
					idx++;
				if (idx == 10) {
					System.out.println(-1);
					return;
				}
			}
			
			//1의 자리 1추가
			//각 자릿수의 최솟값은 index값이므로 값이 10이 되어서 올림을 할 때
			//올림 값이 index보다 크면 그냥 + 1, 아니면 index값으로 올려줌
			//11 -> 20
			//9876543210
			ans[0]++;
			for (int i = 0; i < len; i++) {
				if ((ans[i + 1] != 0 && ans[i] >= ans[i + 1]) || ans[i] == 10) {
					ans[i] = i;//최솟값
					ans[i + 1]++;//올림값은 + 1
					if (ans[i + 1] < i + 1)//올림값이 최소보다 작으면 최소값으로 변경해줌
						ans[i + 1] = i + 1;
				}
			}
			if (ans[len] > 0)//처음 올림 됐으면 길이++
				len++;
			if (check(ans, len))//감소하는 수인지 체크
				num++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = len - 1; i >= 0; i--) {
			sb.append(ans[i]);
		}
		System.out.println(sb.toString());
	}//end main
	
	static boolean check(int[] arr, int len) {
	
		for (int i = 0; i < len - 1; i++) {
			if (arr[i + 1] <= arr[i])
				return false;
		}
		return true;
	}
}//end class
