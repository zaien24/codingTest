package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 투포인터_B2470_두용액 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    
    static int N;
    static int[] A;
   
    static void input() {
    	N = scan.nextInt();
    	A = new int[N+1];
    	for (int i = 1; i <= N; i++) {
    		A[i] = scan.nextInt();
    	}
    }
    
    
    static void pro() {
    	Arrays.sort(A, 1, N+1);
    	
    	int best_sum = Integer.MAX_VALUE;
    	int v1 = 0, v2 = 0,  L = 1, R = N;
    	
    	while (L < R) {
    		if (best_sum > Math.abs(A[L] + A[R])) {
    			best_sum = Math.abs(A[L] + A[R]);
    			v1 = A[L];
    			v2 = A[R];
    		}
    		if (A[L] + A[R] > 0) R--;
    		else L++;
    	}
    	sb.append(V1).append(' ').append(v2);
    	System.out.println(sb);
    }
    
    public static void main(String[] args) {
    	input();
    	pro();
    	    	
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