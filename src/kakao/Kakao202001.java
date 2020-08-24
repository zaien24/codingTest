package kakao;

public class Kakao202001 {

	public static int solution(String s) {
		int answer = s.length(); // 최대값으로 초기화
		
		for (int i = 1; i <= s.length()/2; ++i) {  // 절반까지만 검사
			int pos = 0; // 연산을 수행하는 위치
			int len = s.length(); // ???
			
			for ( ; pos + i <= s.length(); ) {
				String unit = s.substring(pos, pos + i);
				pos += i;
				
				int cnt = 0;
				for ( ; pos + i <= s.length(); ) {
					if (unit.equals(s.substring(pos, pos + i))) {
						++cnt;
						pos += i;
					} else {
						break;
					}
				}
				
				if (cnt > 0) {
					len -= i * cnt;
					
					if (cnt < 9) {
						len += 1;
					} else if (cnt < 99) {
						len += 2;
					} else if (cnt < 999) {
						len += 3;
					} else {
						len += 4;
					}
				}	
				answer = Math.min(answer, len);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
 
		System.out.println(solution("aaaa"));
	}

}
