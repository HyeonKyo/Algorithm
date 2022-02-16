package 카카오채용연계형인턴십2021;

public class Solution_거리두기확인하기_lv2 {
	
	static int[] answer;
	static char[][] m = new char[5][5];
	static boolean[][] v = new boolean[5][5];
	static int[] dl = {-1, 0, 1, 0};
	static int[] dr = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		String[][] s = {
				{"OOPOX", "OXXOP", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		int[] res = solution(s);
		for (int i = 0; i < 5; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}
	
	
	
    static public int[] solution(String[][] places) {
    	answer = new int[] {1, 1, 1, 1, 1};
        for (int room = 0; room < 5; room++) {
        	String[] map = places[room];
        	for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i].charAt(j) == 'P' && !v[i][j]) {
						v[i][j] = true;
						dfs(room, i, j, 0, map);
						v[i][j] = false;
					}
				}
			}
		}//end iter
        
        return answer;
    }//end func
    
    static void dfs(int room, int l, int r, int depth, String[] map) {
    	if (depth != 0 && map[l].charAt(r) == 'P')
    	{
    		answer[room] = 0;
    		return;
    	}
    	if (depth >= 2 || map[l].charAt(r) == 'X')
    		return;
    	for (int i = 0; i < 4; i++) {
    		int il = l + dl[i];
    		int ir = r + dr[i];
    		if (il < 0 || il >= 5 || ir < 0 || ir >= 5 || v[il][ir])
    			continue;
    		v[il][ir] = true;
    		dfs(room, il, ir, depth + 1, map);
    		v[il][ir] = false;
		}
    }
}//end class
