import java.io.*;
import java.util.*;

public class Main {
	
	static int T,N,M;
	static int[] A, B;

	static int lower_bound(int[] A, int L, int R, int X) {
		int result = L - 1;
		
		while (L<=R) {
			int mid = (L+R)/2;

			if (A[mid] < X) {
				result = mid;
				L = mid + 1;
			} else if (X <= A[mid]) {
				R = mid - 1;
			}
		}

		return result;
	}

	static void func() {
		int ans = 0;

		Arrays.sort(B, 1, M+1);

		for (int i=1;i<=N;i++) {
			ans += lower_bound(B, 1, M, A[i]);
		}

		System.out.println(ans);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			A = new int[N+1];
			B = new int[M+1];

			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=N;j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=M;j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}

			func();
		}

	}

}