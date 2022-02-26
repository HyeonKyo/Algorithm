package Math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10250_ACM호텔 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = null;
		int T = 0;
		try {
			T = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < T; i++) {
			int H = 0;
			int W = 0;
			int N = 0;
			try {
				s = br.readLine();
				String[] str = s.split(" ");
				H = Integer.parseInt(str[0]);
				W = Integer.parseInt(str[1]);
				N = Integer.parseInt(str[2]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int floor = 0;
			int room = 0;
			
			floor = (N - 1) % H + 1;
			room = (N - 1) / H + 1;
			System.out.printf("%d%02d\n", floor, room);	
		}
	}
}