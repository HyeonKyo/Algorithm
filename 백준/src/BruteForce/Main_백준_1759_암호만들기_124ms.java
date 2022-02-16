package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1759_암호만들기_124ms {
	
	static int L;
	static int C;
	static int consonant;
	static int vowel;
	static char[] list;
	static char[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//1. 입력 받아서 1차원 배열에 알파벳 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		//2. 알파벳 정렬
		Arrays.sort(list);
		
		//3. 결과 저장 배열 만들고 조합 생성
		result = new char[L];
		combi(0, 0);
		//4. 출력
		System.out.print(sb.toString());
	}//end main
	
	static void combi(int start, int depth) {
		//조합 완성되면 유효성 체크 후 저장
		if (depth == L) {
			consonant = 0;
			vowel = 0;
			checkCount();
			if (consonant >= 2 && vowel >= 1) {
				for (int i = 0; i < L; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		//조합 생성 코드
		for (int i = start; i < C; i++) {
			result[depth] = list[i];
			combi(i + 1, depth + 1);
		}
	}
	
	static void checkCount() {
		for (int i = 0; i < L; i++) {
			switch (result[i]) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				vowel++;
				break;
			default:
				consonant++;
				break;
			}
		}
	}
}//end class
/*
 * 1. 알파벳 입력 받은 후 정렬 수행
 * 2. 정렬된 알파벳의 앞의 인덱스부터 result배열에 넣어주면서 조합 생성
 * 3. L만큼 조합된 result배열의 유효성 체크
 * 		=> 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
 * 4. 유효하면 sb에 저장
 * 
 * */
