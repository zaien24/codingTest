package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 정렬_B15970_화살표그리기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    
    static int N;
    static ArrayList<Integer>[] a;
    
    static void input() {
    	N = scan.nextInt();
    	a = new ArrayList[N+1];
    	for (int color = 1; color <= N; color++) {
    		a[color] = new ArrayList<Integer>();
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		int coord, color;
    		coord = scan.nextInt();
    		color = scan.nextInt();
    		a[color].add(coord);
    	}
    }
    
    static int toLeft(int color, int idx) {
    	if (idx == 0) {
    		return Integer.MAX_VALUE;
    	}
    	return a[color].get(idx) - a[color].get(idx - 1);
    }
    
    static int toRight(int color, int idx) {
    	if (idx + 1 == a[color].size()) {
    		return Integer.MAX_VALUE;
    	}
    	return a[color].get(idx+1) - a[color].get(idx);
    }
    
    static void pro() {
    	for (int color = 1; color <= N; color++) {
    		Collections.sort(a[color]);
    	}
    	
    	int ans = 0;
    	for (int color = 1; color <= N; color++) {
    		for (int i = 0; i < a[color].size(); i++) {
    			int left_distance = toLeft(color, i);
    			int right_distance = toRight(color, i);
    			ans += Math.min(left_distance, right_distance);
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