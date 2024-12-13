package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_B7795_241213 {
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;
    
    private static int lower_bound(int[] A, int L, int R, int X) {
    	// A[L...R] 에서 X 미만의 수(X 보다 작은 수 ) 중 제일 오른쪽 인덱스를 return 하는 함수 
    	// 그런 게 없다면 L - 1 을 return 한다. 
    	int result = L - 1;
    	while (L <= R) {
    		int mid = (L + R) / 2;
    		if (A[mid] < X) {
    			result = mid;
    			L = mid + 1;
    		} else if (A[mid] >= X) {
    			R = mid - 1;
    		}
    	}    	
		return result;
	}
    

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		int TT;
		TT = Integer.parseInt(st.nextToken());
		
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        A = new int[N + 1];
	        B = new int[M + 1];
	        st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= N; i++) {
	            A[i] = Integer.parseInt(st.nextToken());
	        }
	        st = new StringTokenizer(br.readLine());
	        for (int i = 1; i <= M; i++) {
	            B[i] = Integer.parseInt(st.nextToken());
	        }
	        
			// B 배열에 대해 이분탐새을 할 예정이니까, 정렬을 해주자!
	    	Arrays.sort(B, 1, M + 1);
	    	
	    	int ans = 0;
	    	for (int i = 1; i <= N; i++) {
	    		// A[i]를 선택했을 때, B 에서는 A[]보다 작은 게 몇 개나 있는지 count하기 
	    		ans += lower_bound(B, 1, M, A[i]);
	    	}
	    	System.out.println(ans);
		}

	}
}
