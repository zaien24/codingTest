package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 완전탐색_B9663_1 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, ans;
    static int[] col;

    static void input() {

    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
     	if (c1 == c2) return true;
    	if (r1 - c1 == r2 - c2) return true;
    	if (r1 + c1 == r2 + c2) return true;
		return false;
	}
    
    private static boolean validity_check() {
    	for (int i=1;i<=N;i++) {
    		// i, col[i]
    		for (int j=1;j<i;j++) {
    			// j, col[j]
    			if (attackable(i, col[i], j, col[j])) {
    				return false;
    			}
    		}
    	}
		return true;
	}
    
    

	private static void rec_func(int row) {
    	if (row == N + 1) {
    		if (validity_check()) {
    			ans++;	
    		}
			
    	} else {
    		for (int c = 1; c <= N; c++) {
				col[row] = c;
    			rec_func(row + 1);
    			col[row] = 0;    			
    		}
    	}
		
	}
    
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		N = Integer.parseInt(st.nextToken());		
    	col = new int[N + 1];
    	
		rec_func(1);
		System.out.println(ans);
	}
	
}