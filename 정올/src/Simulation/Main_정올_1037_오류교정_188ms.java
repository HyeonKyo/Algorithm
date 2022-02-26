package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_1037_오류교정_188ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] row = new int[n];
		int[] col = new int[n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				switch (line.charAt(j * 2)) {
				case '1':
					row[i]++;
					col[j]++;
					break;
				}
			}
		}
		
		int cnt = 0;
		int il = 0;
		int ir = 0;
		for (int i = 0; i < n; i++) {
			if ((row[i] & 1) != 0) {
				cnt++;
				il = i + 1;
			}
			if ((col[i] & 1) != 0) {
				cnt++;
				ir = i + 1;
			}
		}
		if (cnt == 0) {
			System.out.println("OK");
		} else if (cnt == 2 && il != 0 && ir != 0) {
			System.out.println("Change bit (" + il + "," + ir + ")");
		} else {
			System.out.println("Corrupt");
		}
	}//end main
}
