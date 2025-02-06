import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class Main {
	static int N;
	static int[] score;

	public static void proc() {
		float result = 0;

		//최대값
		int max = Math.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			if (max < score[i]) {
				max = score[i];
			} 
			sum += score[i];
		}
		
		result = (sum / max * 100) / N;
		System.out.println(result);
	}
	
	public static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenzier(br.readLine());

		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenzier(br.readLine());
			score[i] = st.nextToken();
		}
	}

	public static void main(String[] args) {
		input();
		proc();
	}
}