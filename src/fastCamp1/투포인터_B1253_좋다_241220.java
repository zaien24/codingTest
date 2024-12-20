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

public class 투포인터_B1253_좋다_241220 {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] A;
    
    private static boolean func(int target_idx) {
    	int L = 1, R = N;
    	int target = A[target_idx];
    	
    	while (L < R) {
    		if (L == target_idx) L++;
    		else if (R == target_idx) R--;
    		else {
    			if (A[L] + A[R] > target) R--;
    			else if (A[L] + A[R] == target) return true;
    			else L++;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A, 1, N + 1);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
        	if (func(i)) ans++;
        }
        
        System.out.println(ans);
    }    
	
}