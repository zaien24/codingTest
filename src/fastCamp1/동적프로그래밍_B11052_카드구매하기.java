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

public class 동적프로그래밍_B11052_카드구매하기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    
    static int N;
    static int[] Dy;
    static int[] A;
    
    static void input() {
    	N = scan.nextInt();
    	A = new int[N+1];
    	for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
    	Dy = new int[N+1];
    }
    
    static void pro() {
    	Dy[0] = 0;
    	
    	for (int i = 1; i <= N; i++) {
    		for (int cnt = 1; cnt <= i; cnt++) {
    			Dy[i] = Math.max(Dy[i], Dy[i-cnt] + A[cnt]);
    		}
    	}
    	
    	System.out.println(Dy[N]);
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