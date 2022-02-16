package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_양소정 {
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dy = {-1, 1};
        int tcxn = 100;
        int tcyn = 100;
        for(int tc=1;tc<=1;tc++) {
            br.readLine();
            int[][] lad = new int[tcxn + 2][tcyn + 2];
            for(int i=1;i<=tcyn;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=tcxn;j++) {
                	lad[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int y = 0;
            for(int i=1;i<=tcyn;i++) {
                if(lad[tcxn][i]==2) {
                    y = i;
                    break;
                }
            }
            for(int i=tcxn;i>1;i--) {
                for(int j=0;j<2;j++) {
                    if(lad[i][y+dy[j]]==1) {
                        while(lad[i][y+dy[j]]==1){//계속올라가기
                                y = y+dy[j];
                        }
                        break;
                    }
                }
            }
            sb.append("#"+tc+" "+(y-1)+"\n");
        }
        System.out.println(sb);
    }
}
/*
 * 자료구조를 큐로 하지 않고, arrayList로 하면 더 빠르게 가능
 * k-1개를 빼고 넣는 작업 없이 바로 인덱스로 접근해서 값 얻고, 인덱스 값 삭제하는 방식 가능
 * 
 * */