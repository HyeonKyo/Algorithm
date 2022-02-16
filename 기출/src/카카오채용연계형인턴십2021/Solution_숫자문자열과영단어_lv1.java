package 카카오채용연계형인턴십2021;

public class Solution_숫자문자열과영단어_lv1 {
	
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}
	
    static public int solution(String s) {
        int answer = 0;
        String[] word = new String[] {
        		"zero", "one", "two", "three", "four",
        		"five", "six", "seven", "eight", "nine"
        		};
        String[] replace = new String[] {
        		"0", "1", "2", "3", "4",
        		"5", "6", "7", "8", "9"
        		};
        
        String res = s;
        for (int i = 0; i < 10; i++) {
			res = res.replace(word[i], replace[i]);
		}
        answer = Integer.parseInt(res);
        return answer;
    }
}
