package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 완전탐색_B9663 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
    	N = scan.nextInt();
    	col = new int[N + 1];
    }
    
    static int N, ans;
    static int[] col;
    
    private static boolean attackable(int r1, int c1, int r2, int c2) {
    	if (c1 == c2) return true;
    	if (r1 - c1 == r2 - c2) return true;
    	if (r1 + c1 == r2 + c2) return true;
		return false;
	}
    
    private static boolean validity_check() {
    	for (int i=1;i<=N;i++) {
    		// i, col[i]
    		for (int j=1;j<i;j++) {
    			// j, col[j]
    			if (attackable(i, col[i], j, col[j])) {
    				return false;
    			}
    		}
    	}
		return true;
	}
    
    

	private static void rec_func(int row) {
    	if (row == N + 1) {
			ans++;
    	} else {
    		for (int c = 1; c <= N; c++) {
    			boolean possiable = true;
    			// valid check (row, c)
    			for (int i=1;i<=row-1;i++) {
    				// (i, col[i])
    				if (attackable(row, c, i, col[i])) {
    					possiable = false;
    					break;
    				}
    			}
    			if (possiable) {
    				col[row] = c;
        			rec_func(row + 1);
        			col[row] = 0;
    			}
    			
    		}
    	}
		
	}
    
	

	public static void main(String[] args) {
		input();
		
		// 1번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘 
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}