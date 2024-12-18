package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 투포인터_B13144_ListOfUniqueNumbers {
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static int[] A, cnt;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        cnt = new int[100000 + 1];        
       	N = Integer.parseInt(st.nextToken());
    	A = new int[N+1];
    	
    	st = new StringTokenizer(br.readLine());
        
    	for (int i = 1; i <= N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}   
    	cnt = new int[1000000+1];
    	
    	long ans = 0;
    	
    	for (int L=1, R=0; L<=N; L++){  // L 마다 R 을 최대한 옮겨 줄 계획이다.
            // R 을 옮길 수 있는 만큼 옮긴다.
            while (R + 1 <= N && cnt[A[R+1]] == 0){
                R++;
                cnt[A[R]]++;
            }
            
            // 정답을 갱신한다
            ans += R - L + 1;

            // L 을 옮겨주면서 A[L] 의 개수를 감소시킨다.
            cnt[A[L]]--;
        }

        System.out.println(ans);
    }
   
}