package Math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2869_달팽이는올라가고싶다 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int A = 0;
		int B = 0;
		int V = 0;
		try {
			s = br.readLine();
			String[] str = s.split(" ");
			A = Integer.parseInt(str[0]);
			B = Integer.parseInt(str[1]);
			V = Integer.parseInt(str[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println((int)Math.ceil((double)(V - B)/(A - B)));
	}
}
