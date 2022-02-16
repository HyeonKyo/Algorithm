package 카카오채용연계형인턴십2021;

public class Solution_미로탈출_lv4 {
	
	public static void main(String[] args) {
		int[][] ro = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
		int[] tr = {2, 3};
		
		System.out.println(solution(4, 1, 4, ro, tr));
	}
	
	static int N;
	static int[] trap;
	static int[][] r;
	static int[] t;
	static int[] cnt;
	static int min = Integer.MAX_VALUE;
	static int endnum;
	
	static int sidx = 0;
	static int eidx = 1;
	static int tidx = 2;
	
	
	
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        N = n;
        r = roads;
        endnum = end;
        trap = traps;
        t = new int[n + 1];
        for (int i = 0; i < traps.length; i++) {
			t[traps[i]] = i;
		}
        
        cnt = new int[n + 1];
        cnt[start]++;
        
        move(start, 0, 0);
        return min;
    }
	
	static void move(int start, int time, int trap) {
		if (start == endnum) {
			if (min > time)
				min = time;
			return;
		}
		if (cnt[start] >= 3) {
			return;
		}
		if (t[start] > 0) {
			trap ^= 1 << t[start];//비트에 트랩 인덱스의 활성화 상태 나타냄
		}
		if ((trap & 1 << t[start]) != 0) {
			
		}
		for (int[] path : r) {
			if (path[sidx] == start) {
				cnt[path[eidx]]++;
				move(path[eidx], time + path[tidx]);
				cnt[path[eidx]]--;
			}
		}
	}
	
	static void reverseRoot(int start) {
		for (int[] path : r) {
			if (path[sidx] == start || path[eidx] == start) {
				int tmp = path[sidx];
				path[sidx] = path[eidx];
				path[eidx] = tmp;
			}
		}
	}
}//end class

/*
 * 비트로 트랩의 활성화 상태는 알 수 있음
 * 2번 트랩이 활성화 된 상태면 연결된 것들의 방향을 어떻게??
 * 
 * */
