package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_10158_개미_S4_80ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int x = 0;
		int tmp = t - (w - p);
		if (tmp <= 0)
			x = p + t;
		else {
			tmp /= w;
			int move = (t - (w - p)) % w;
			if ((tmp & 1) == 0) {
				x = w;
				move *= -1;
			}
			x += move;
		}
		
		int y = 0;
		tmp = t - (h - q);
		if (tmp <= 0)
			y = q + t;
		else {
			tmp /= h;
			int move = (t - (h - q)) % h;
			if ((tmp & 1) == 0) {
				y = h;
				move *= -1;
			}
			y += move;
		}
		
		System.out.println(x + " " + y);
	}//end main
}

