package NumberTheory;

import java.util.Scanner;

public class Main_백준_2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int a = n >= m ? n : m;
		int b = n < m ? n : m;
		int g = gcd(a, b);
		System.out.println(g);
		System.out.println(n * m / g);
	}
	
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
/*
 * 유클리드 호제법을 이용해서 풀어보자
 * A >= B, r = A % B일때
 * A = Bq + r and A=ad B=bd(d는 gcd) (a, b는 서로소)
 * 위의 식들을 이용하면
 * r = A - Bq, A와 B를 위 식으로 표시
 * r = ad - bdq = (a - bq)d
 * 이제 b와 a - bq가 서로소이면 B와 r의 최대공약수도 d임이 증명됨.
 * 귀류법으로 서로소가 아니라고 가정하고 모순을 도출
 * b 와 a - bq가 서로소가 아니면 공약수 p가 있다는 뜻
 * b = mp, a - bq = np, b = mp를 2번째 식에 넣으면
 * a - mpq = np -> a로 정리하면, a = (n + mq)p
 * 그러면 a와 b는 p라는 공약수를 갖게 되는데 가장 처음에 a와 b는 서로소임을
 * 확인했으므로 모순이 발생한다.
 * 따라서 b와 a - bq는 서로소이므로 다음이 증명되었다.
 * gcd(a, b) = gcd(b, r)
 * 
 * 
 * gcd(a, b) = gcd(b, r) 
 * r이 0이 될때까지 반복
 * 
 * */
