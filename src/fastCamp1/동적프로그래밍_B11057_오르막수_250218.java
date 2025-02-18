import java.io.*;
import java.util.*;

public class Main {


	static int N; 
	static int[][] Dy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		Dy = new int[N+1][10];

		for (int num=0;num<=9;num++) {
			Dy[1][num] = 1;
		}

		for (int len=2;len<=N;len++) {
			for (int num=0;num<=9;num++) {
				for (int prev=0;prev<=num;prev++) {
					Dy[len][num] += Dy[len-1][prev];
					Dy[len][num] %= 10007;
				}
			}
		}

		int ans = 0;
		for (int num=0;num<=9;num++) {
			ans += Dy[N+1][num];
			ans %= 10007;
			
		}
		System.out.println(ans);
	}
}