package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_1021_장난감조립  {
	
	static int N;
	static int[] need;
	static List<List<Integer>> assem = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		need = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			assem.add(new ArrayList<Integer>());
		}
		int cnt = Integer.parseInt(br.readLine());
		while (cnt-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> tmp = assem.get(Integer.parseInt(st.nextToken()));
			tmp.add(Integer.parseInt(st.nextToken()));
			tmp.add(Integer.parseInt(st.nextToken()));
		}
		recur(N);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (need[i] > 0) {
				sb.append(i).append(" ").append(need[i]).append("\n");
			}
		}
		System.out.println(sb);
	}//end main
	
	static void recur(int n) {
		List<Integer> tmp = assem.get(n);
		int size = tmp.size();
		if (size <= 0) {
			need[n]++;
			return;
		}
		for (int i = 0; i < size; i += 2) {
			int num = tmp.get(i).intValue();
			int cnt = tmp.get(i + 1).intValue();
			for (int j = 0; j < cnt; j++) {
				recur(num);
			}
		}
	}
}//end class

/*
 * 1. N받기
 * 2. 반복횟수 받기
 * 3. 관계 입력 받기 -> List의 배열로 -> 뺄때는 조합숫자get + 반복숫자get -> size만큼반복
 * 4. 7은 6이 3개 4가 5개 -> 7 = recur(6)을 3번, recur(4)를 5번 실행
 * 5. 재귀 종료 조건은 기본 조합일 경우
 * 6. 2차원 배열의 arr[n][0~~2i] -> arr[n]의 사이즈가 0이면 종료
 * 7. arr[n]의 size = 0이면, n을 숫자 저장 배열에 추가하고 리턴
 * 
 */
