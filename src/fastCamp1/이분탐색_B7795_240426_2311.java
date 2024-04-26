package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이분탐색_B7795_240426_2311 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	A = new int[N + 1];
    	B = new int[M + 1];
    	for (int i = 1; i <= N; i++) {
    		A[i] = scan.nextInt();	
    	}
    	for (int i = 1; i <= M; i++) {
    		B[i] = scan.nextInt();
    	}
    }
    
    static int lower_bound(int[] A, int L, int R, int X) {
    	int res = L - 1;
    	while (L <= R) {
    		int mid = (L + R) /2;
    		if (A[mid] < X) {
    			res = mid;
    			L = mid + 1;
    		} else {
    			R = mid - 1;
    		}
    	}
    	return res;
    }
    
    static void pro() {
    	// B배열에 대해 이분탐색을 할 예정이니까, 정렬을해주자!
    	Arrays.sort(B, 1, M + 1);
    	
    	int ans = 0;
    	for (int i = 1; i <= N; i++) {
    		// A[i] 를 선택했을 때,B 에서는 A[i] 보다 작은게 몇개나 있는 지 count하기
    		ans  += lower_bound(B, 1, M, A[i]);
    	}
    }
  
	public static void main(String[] args) {
		int TT;
		TT = scan.nextInt();
		for (int tt = 1; tt<= TT; tt++) {
			input();
			pro();
		}

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
