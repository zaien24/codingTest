import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;

	static int[][] A, S;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N+1][N+1];

		for (int x = 1; x <= N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 1; y <= N; y++) {
				A[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int x1 =  Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			result = S[x2][y2] - S[x1][y1];
			System.out.println(result);
		}
	}
}