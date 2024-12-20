package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// kind 를 O(26) 계산
public class 투포인터_B16472_고냥이_O26_241221 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, kind;
    static String A;
    static int[] cnt;
    
    static void add(char x) {  // x 라는 알파벳 추가
        cnt[x - 'a']++;
    }

    static void erase(char x) {  // x 라는 알파벳 제거
        cnt[x - 'a']--;
    }
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        N = Integer.parseInt(st.nextToken());
        A = br.readLine();
        cnt = new int[26];
        
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R 번째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            while (true) {
            	kind = 0;
            	for (int i = 0; i < 26; i++) {
            		if (cnt[i] != 0) kind++;
            	}
            	if (kind <= N) break;
                erase(A.charAt(L));
                L++;
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
        
    }
}