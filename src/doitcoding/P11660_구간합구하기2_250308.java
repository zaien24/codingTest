import java.io.*;
import java.util.*;

public class Main {
    static StringBuffer sb = new StringBuffer();

	static int N, M;
	static int[][] A;
	static int[][] S;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N+1][N+1];
		S = new int[N+1][N+1];


		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());	
			}
		}

		S[1][1] = A[1][1];
		S[2][1] = A[1][1] + A[2][1];
		S[1][2] = A[1][1] + A[1][2];

		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j];		
			}
		}

		int chk = 1;
		while (chk <= M) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sum = S[x2][y2] - S[x2][y1-1] - S[x1-1][y2] + S[x1-1][y1-1];

			System.out.println(sum);
			chk++;
		}

    }
}