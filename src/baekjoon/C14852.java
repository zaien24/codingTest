package baekjoon;

import java.util.Scanner;

public class C14852 {
	public static long[] d = new long[1000001];
	
	public static long dp(int x) {
		if (x == 0) return 1; 
		if (x == 1) return 2;
		if (x == 2) return 7;
		if (d[x] != 0) return d[x];
		long result = 3 * dp(x - 2) + 2 * dp(x -1);
		for (int i = 3; i <= x; i++) {
			result += (2 * dp(x - i)) % 1000000007;
		}
		return d[x] = result % 1000000007;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(dp(n));
	}
}
 