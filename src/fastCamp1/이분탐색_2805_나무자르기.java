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

public class 이분탐색_2805_나무자르기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M;
    static int[] A;
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	A = new int[N+1];
    	for (int i = 1; i <= N; i++) {
    		A[i] = scan.nextInt();
    	}
    }
    
    static boolean determination(int H) {
    	long sum = 0;
    	for (int i = 1; i <= N; i++) {
    		if (A[i] > H) {
    			sum += A[i] - H;
    		}
    	}
    	return sum >= M;
    }
    
    private static void pro() {
		long L = 0, R = 2000000000, ans = 0;
		// [L....R] 범위 안에 정답이 존재한다.
		// 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
		while ( L <= R ) {
			int mid = (int) ((L + R) / 2);
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid -1;
			}
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