package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬_B11652_카드_241212 {
	
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static long[] a;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	a = new long[N+1];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		a[i] = Long.parseLong(st.nextToken());
    	}
    	
    	Arrays.sort(a, 1, N+1);
    	long mode = a[1];
    	int modeCnt = 1;
    	int curCnt = 1;
    	
    	
    	for (int i = 2; i <= N; i++) {
    		if (a[i] == a[i-1]) {
    			curCnt++;
    		} else {
    			curCnt = 1;
    		}
    		
    		if (curCnt > modeCnt) {
    			modeCnt = curCnt;
    			mode = a[i];
    		}
    	}
    	System.out.println(mode);
    	    	
    }
}