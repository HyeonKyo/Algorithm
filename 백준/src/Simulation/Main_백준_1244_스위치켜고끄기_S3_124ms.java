package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1244_스위치켜고끄기_S3_124ms {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());//스위치 개수
		//스위치 상태 저장
		boolean[] s = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = st.nextToken().equals("1") ? true : false;
		}
		//학생수
		int p = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			String tmp = st.nextToken();//성별
			int n = Integer.parseInt(st.nextToken());//받은 수
			
			switch (tmp) {
			case "1"://남자
				int idx = n - 1;
				while (idx < N) {
					s[idx] ^= true;//상태 변경
					idx += n;//배수 인덱스
				}
				break;
			case "2"://여자
				s[n - 1] ^= true;//시작점 상태 변경
				int il = n - 2;
				int ir = n;
				while (il >= 0 && ir < N && s[il] == s[ir]) {//상태 같으면
					s[il--] ^= true;//좌 우로 상태 변경
					s[ir++] ^= true;
				}
				break;
			}
		}
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i] ? 1 : 0).append(" ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}
		if (sb.charAt(sb.length() - 1) != '\n')
			sb.append("\n");
		System.out.print(sb.toString());
	}//end main
}