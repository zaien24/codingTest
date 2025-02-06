import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
	static int N;
	static int[] score;

	public static void proc() {
		double result = 0;

		//최대값
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			if (max < score[i]) {
				max = score[i];
			} 
			sum += score[i];
		}
		
		result = (sum  * 100.0 / max) / N;
		System.out.println(result);
	}
	
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		score = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		proc();
	}
}