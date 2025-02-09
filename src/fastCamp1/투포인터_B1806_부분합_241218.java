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

public class 투포인터_B1806_부분합_241218 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int n, S;
    static int[] a;
    
    
    static void input() {
    	n = scan.nextInt();
    	S = scan.nextInt();
    	a = new int[n+1];
    	for (int i = 1; i <= n; i++) {
    		a[i] = scan.nextInt();
    	}
    }
    
    static void pro() {
    	int R = 0, sum = 0, ans = n+1;
    	for (int L = 1; L <= n; L++) {
    		// L - 1을 구간에서 제외하기 
    		sum -= a[L-1];
    		
    		// R을 옮길 수 있을 때 까지 옮기기
    		while (R+1 <= n && sum < S) 
    			sum += a[++R];
    		
    		//[L...R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기 
    		if (sum >= S) 
    			ans = Math.min(ans,  R-L+1);
    	}
    	
    	if (ans == n + 1) {
    		ans = 0;
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