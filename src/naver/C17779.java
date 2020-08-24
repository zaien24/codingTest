package naver;

import java.util.Arrays;
import java.util.Scanner;

public class C17779 {
	
	private static final int INF = 987654321;
	
	static int N;
	static int Arr[][] = new int[20][20];
	static int Mark[][] = new int[20][20];
	
	
	static void fill(int r, int c, int value) {
		if (r < 0 || r > N-1 || c < 0 || c > N-1) return;
		if (Mark[r][c] != 0) return;
		
		Mark[r][c] = value;
		fill(r-1, c, value);
		fill(r+1, c, value);
		fill(r, c-1, value);
		fill(r, c+1, value);
	}
	
	static int solve() {
		int ret = INF;
		
		for (int x = 0; x <= N-3; ++x) {
			for (int y = 1; y <= N-2; ++y) {
				for (int d1 = 1; x+d1 <= N-2 && y-d1 >= 0; ++d1) {
					for (int d2 = 1; x+d1+d2 <= N-1 && y+d2 <= N-1; ++d2) {
						for (int i = 0; i < N; ++i) {
							Arrays.fill(Mark[i], 0);
						}
						for (int i = 0; i <= d1; ++i) {
							Mark[x + i][y - i] = 5;
							Mark[x + d2 + i][y + d2 - i] = 5;
						}
						for (int i = 0; i <d2; ++i) {
							Mark[x + i][y + i] = 5;
							Mark[x + d1 + i][y - d1 + i] = 5;
						}
						for (int r = x -1; r >= 0; --r) {
							Mark[r][y] = 1;
						}
						for (int c = y+d2 + 1; c < N; ++c) {
							Mark[x+d2][c] = 2;
						}
						for (int c = y-d1 -1; c >= 0; --c) {
							Mark[x+d1][c] = 3;
						}
						for (int r = x+d1+d2 + 1; r < N; ++r) {
							Mark[r][y-d1+d2] = 4;
						}
						
						fill(0, 0, 1);
						fill(0, N-1, 2);
						fill(N-1, 0, 3);
						fill(N-1, N-1, 4);
						
						int people[] = new int[6];
						for (int r = 0; r < N; ++r)
							for (int c = 0; c < N; ++c)
								people[Mark[r][c]] += Arr[r][c];
						people[5] += people[0];
						
						int minP = INF, maxP = 0;
						for (int i = 1; i <= 5; ++i) {
							minP = Math.min(minP, people[i]);
							maxP = Math.max(maxP, people[i]);
						}
						
						ret = Math.min(ret, maxP - minP);
					}
				}
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				Arr[i][j] = sc.nextInt();
		
		System.out.println(solve());

	}

}
