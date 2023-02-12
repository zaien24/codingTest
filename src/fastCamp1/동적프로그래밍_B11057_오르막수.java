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

public class 동적프로그래밍_B11057_오르막수 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static int[][] Dy;
    
    
    static void input() {
    	N = scan.nextInt();
    	Dy = new int[N+1][10];
    }
    
    static void pro() {
    	// 초기값 구하기
    	for (int num = 0; num <= 9; num++) {
    		Dy[1][num] = 1;    		
    	}
    	
    	for (int len = 2; len <= N; len++) {
    		for (int num = 0; num <= 9; num++) {
    			for (int prev = 0; prev <= num; prev++) {
    				Dy[len][num] += Dy[len-1][prev];
    				Dy[len][num] %= 10007;
    				
    			}
    		}
    	}
    	
    	 // Dy배열로 정답 계산하기
        int ans = 0;
        for (int num = 0; num <= 9; num++) {
            ans += Dy[N][num];
            ans %= 10007;
        }

        System.out.println(ans);
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