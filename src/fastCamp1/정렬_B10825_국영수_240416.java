package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬_B10825_국영수_240416 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
 
    static class Elem implements Comparable<Elem> {
    	
    	public String name;
    	
    	public int korean, english, math;

		@Override
		public int compareTo(Elem other) {
			
			// 국어 점수 내림차순
			if (korean != other.korean) return other.korean - korean;	
			// 영어 점수 오름차순
			if (english != other.english) return english - other.english;
			// 수학 점수 내림차순
			if (math != other.math) return other.math - math; 
			
			return name.compareTo(other.name);
		}
    }
    
    static int N;
    static Elem[] a;

    static void input() {
        N = scan.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].korean = scan.nextInt();
            a[i].english = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }
    
    static void pro() {
    	Arrays.sort(a);
    	for (int i = 0; i < N; i++) {
    		sb.append(a[i].name).append('\n');
    	}
    	System.out.println(sb.toString());
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