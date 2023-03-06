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

public class 완전탐색_B14888 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, max, min;
    static int[] nums, operators;
    
    static void input() {
    	N = scan.nextInt();
    	nums = new int[N+1];
    	for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    	for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();
    	
    	max = Integer.MIN_VALUE;
    	min = Integer.MAX_VALUE;
    			
    			
    }
    
    
    private static void rec_func(int k) {
    	if (k == N) {
    		
    	}
    }
    
    public static void main(String[] args) {
    	input();
    	rec_func(1);
    	    	
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