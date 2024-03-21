package baekjoon;

import java.util.*;
import java.io.*;

public class C9663 {
	
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static void input() {
		N = scan.nextInt();		
		col = new int[N + 1];
	}

	static int N, ans;
	static int[] col;
	
	static boolean attackable(int r1, int c1, int r2, int c2) {
		if (c1 == c2) return true;
		if (r1 - c1 == r2 - c2) return true;
		if (r1 + c1 == r2 + c2) return true;
		return false;
	}
	
	static boolean validity_check() {
		for (int i=1;i<=N;i++) {
			// (i, col[i])
			for (int j=1;j<i;j++) {
				// (j, col[j])
				if (attackable(i, col[i], j, col[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void rec_func(int row) {
		if (row == N + 1) {
			System.out.println("row == N + 1 : " + row);
			System.out.println("ans : " + ans);
			if (validity_check()) {				
				ans++;
				System.out.println("ans++ : " + ans);
			}
		} else {
			System.out.println("row : " + row);
			for (int c =1; c<=N;c++) {
				System.out.println("c : " + c);
				col[row] = c; 
				System.out.println("col[row] : " + col[row]);
				System.out.println("rec_func(row+1)전 : " + row);
				rec_func(row+1);
				System.out.println("rec_func(row+1)후 : " + row);
				System.out.println("col[row] : " + col[row]);
				col[row] = 0;
				
			}
		}
		
	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(ans);
	}

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
	}
}
