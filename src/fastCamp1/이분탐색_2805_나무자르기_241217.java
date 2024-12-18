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

public class 이분탐색_2805_나무자르기_241217 {
	
    static StringBuilder sb = new StringBuilder();
	
    static int N, M;
    static int[] A;
    
    static boolean determination(int H) {
    	long sum = 0;
    	for (int i = 1; i <= N; i++) {
    		if (A[i] > H) {
    			sum += A[i] - H;
    		}
    	}
    	return sum >= M;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	A = new int[N+1];
    	st = new StringTokenizer(br.readLine());
    	
    	for (int i = 1; i <= N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
		
		long L = 0, R = 2000000000, ans = 0;
		// [L....R] 범위 안에 정답이 존재한다.
		// 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
		while ( L <= R ) {
			int mid = (int) ((L + R) / 2);
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid -1;
			}
		}
		System.out.println(ans);
    	    	
    }
}