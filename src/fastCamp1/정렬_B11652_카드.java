package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬_B11652_카드 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N;
    static long[] a;
    
    static void input() {
    	N = scan.nextInt();
    	a = new long[N+1];
    	for (int i = 1; i <= N; i++) {
    		a[i] = scan.nextLong();
    	}
    }
    
    static void pro() {
    	Arrays.sort(a, 1, N+1);
    	long mode = a[1];
    	int modeCnt = 1;
    	int curCnt = 1;
    	
    	for (int i = 2; i <= N; i++) {
    		if (a[i] == a[i-1]) {
    			curCnt++;
    		} else {
    			curCnt = 1;
    		}
    		
    		if (curCnt > modeCnt) {
    			modeCnt = curCnt;
    			mode = a[i];
    		}
    	}
    	System.out.println(mode);
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