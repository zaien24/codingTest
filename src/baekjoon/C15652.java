package baekjoon;

import java.io.*;
import java.util.*;

public class C15652 {
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] selected;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());			
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M + 1];
	}

	static void rec_func(int k) {
		if (k == M + 1) { // 1 ~ M 번째를 전부 다 골랐다!
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            int start = selected[k-1];
            System.out.println("selected : " + Arrays.toString(selected));
            
            if (start == 0) start = 1;
            for (int cand = start; cand <= N; cand++) {
                selected[k] = cand;
                System.out.println("selected[k] = cand");
                System.out.println("selected : " + Arrays.toString(selected));
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
	}



	public static void main(String args[]) throws IOException {
		input();
		rec_func(1);
		System.out.println(sb.toString());
	}

}
