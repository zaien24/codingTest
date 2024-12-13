package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 정렬_B15970_화살표그리기_241212_2 {
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static ArrayList<Integer>[] a;
    
    static int toLeft(int color, int idx) {
    	if (idx == 0) {
    		return Integer.MAX_VALUE;
    	}
    	return a[color].get(idx) - a[color].get(idx - 1);
    }
    
    static int toRight(int color, int idx) {
    	if (idx + 1 == a[color].size()) {
    		return Integer.MAX_VALUE;
    	}
    	return a[color].get(idx+1) - a[color].get(idx);
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
    	N = Integer.parseInt(st.nextToken());
    	a = new ArrayList[N+1];
    	for (int color = 1; color <= N; color++) {
    		a[color] = new ArrayList<Integer>();
    	}
    	
    	for (int i = 1; i <= N; i++) {		
    	    Scanner sc = new Scanner(System.in);
    		int coord, color;	
    		coord = sc.nextInt();
    		color = sc.nextInt();
    		a[color].add(coord);
    	}
    	for (int color = 1; color <= N; color++) {
    		Collections.sort(a[color]);
    	}
    	
    	int ans = 0;
    	for (int color = 1; color <= N; color++) {
    		for (int i = 0; i < a[color].size(); i++) {
    			int left_distance = toLeft(color, i);
    			int right_distance = toRight(color, i);
    			ans += Math.min(left_distance, right_distance);
    		}
    	}
    	System.out.println(ans);
    	    	
    }
}