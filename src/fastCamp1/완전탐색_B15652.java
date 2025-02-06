package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 완전탐색_B15652 {

	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[] selected, used;
	
	private static void rec_func(int k) {		
		//출력
		if (k == M + 1 ) {
			for (int i=1;i<=M;i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			int start = selected[k-1];
			if (start == 0) start =1;
			for (int cand=start;cand<=N;cand++) {
				selected[k] = cand;									
				rec_func(k+1);
				selected[k] = 0;								
			}				
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M + 1];
		used = new int[N + 1];
		
		rec_func(1);		
		System.out.println(sb);
	}

}


