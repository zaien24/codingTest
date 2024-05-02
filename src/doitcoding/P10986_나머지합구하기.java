package doitcoding;

import java.io.IOException;
import java.util.Scanner;

public class P10986_나머지합구하기 {
	public  static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];
		
		long answer = 0;
		
		S[0] = sc.nextInt();
		
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M);
			
			System.out.println("S[i] :"+  S[i]);
			System.out.println("remainder :"+  remainder);
			if (remainder == 0) answer++;
			System.out.println("C[remainder] 전 :"+  C[remainder]);
			C[remainder]++;
			System.out.println("C[remainder] 후 :"+  C[remainder]);
		}
		
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				answer = answer + (C[i] * (C[i] -1) /2);
			}
		}
		
		System.out.println(answer);
	}

}
