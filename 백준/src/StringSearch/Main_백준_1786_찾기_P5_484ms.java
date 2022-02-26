package StringSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//틀렸음 -> 다시해보기
public class Main_백준_1786_찾기_P5_484ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] t = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();
		
		int lenT = t.length;
		int lenP = p.length;
		
		int[] pi = new int[lenP];
		for (int i = 1, j = 0; i < lenP; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}

			if (p[i] == p[j])
				pi[i] = ++j;
			else
				pi[i] = 0;
		}

		ArrayList<Integer> result = new ArrayList<>();
		int cnt = 0;
		for (int i = 0, j = 0; i < lenT; i++) {
			while (j > 0 && p[j] != t[i]) {
				j = pi[j - 1];
			}
			
			if (p[j] == t[i])
				j++;
			if (j == lenP) {
				result.add(i - lenP + 2);
				cnt++;
				j = pi[j - 1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (Integer n : result) {
			sb.append(n).append(" ");
		}
		System.out.println(sb.toString());
	}//end main
}
