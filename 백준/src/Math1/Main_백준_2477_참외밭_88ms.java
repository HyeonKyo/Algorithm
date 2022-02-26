package Math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2477_참외밭_88ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int maxX = 0;
		int maxY = 0;
		int startIdx = 0;
		int[] arr = new int[6];
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "1": case "2"://가로
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] > maxX) {
					maxX = arr[i];
					if (maxY > 0)
						startIdx = i;
				}
				break;
			case "3": case "4"://세로
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] > maxY) {
					maxY = arr[i];
					if (maxX > 0)
						startIdx = i;
				}
				break;
			}
		}
		if (arr[(startIdx + 1) % 6] == maxY || arr[(startIdx + 1) % 6] == maxX)
			startIdx = (startIdx + 1) % 6;
		
		int smallY = (startIdx + 2) % 6;
		int smallX = (startIdx + 3) % 6;
		long area = maxX * maxY - (arr[smallY] * arr[smallX]);
		System.out.println(area * K);
	}//end main
}
/* max값 max값 다음다음값과 다다다음값이 뺄 사각형의 변이다.
 * 최대 x,y의 넓이에서 그 작은 사각형을 빼면된다.
 * 
 * */
