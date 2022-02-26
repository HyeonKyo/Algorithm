package Math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1193_분수찾기 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;
		try {
			x = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int crossCount = 1;
		int preCrossSum = 0;
		int up = 0;
		int down = 0;
		
		while (true) {
			if (x <= preCrossSum + crossCount) {
				int n = x - preCrossSum;
				if (crossCount % 2 == 0) {
					up = n;
					down = crossCount - n + 1;
				} else {
					up = crossCount - n + 1;
					down = n;
				}
				break ;
			} else {
				preCrossSum += crossCount;
				crossCount++;
			}
		}
		System.out.println(up + "/" + down);
	}
}
