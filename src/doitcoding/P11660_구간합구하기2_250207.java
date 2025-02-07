import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;

	static int[][] A, S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N+1][N+1];
		S = new int[N+1][N+1];
		

		for (int x = 1; x <= N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 1; y <= N; y++) {
				A[x][y] = Integer.parseInt(st.nextToken());
				S[x][y] = S[x][y-1] + S[x-1][y] - S[x-1][y-1] + A[x][y];
			}
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int x1 =  Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			result = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1];
			System.out.println(result);
		}
	}
}