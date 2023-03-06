package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import fastCamp1.완전탐색_B9663.FastReader;

public class 완전탐색_B1182 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    
    static int N, S, ans;
    static int[] nums;
       
    static void input() {
    	 N = scan.nextInt();
         S = scan.nextInt();
         nums = new int[N + 1];
         for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    }
    
    
    // value:= k-1 번째 원소까지 골라진 원소들의 합
    private static void rec_func(int k, int value) {
    	if (k == N+1) { // 부분 수열을 하나 완성 시킨 상태
    		// value 가 S랑 같은 지 확인하기 
    		if (value == S ) ans++;
    	}  else {
    		// k 번재 원소를 포함시킬 결정하고 재귀호출해주기
    		// Include
    		rec_func(k + 1, value + nums[k]);
    		// Not Include
    		rec_func(k + 1, value);
    		// Not issue
    	}
    }
    
	public static void main(String[] args) {
		input();
		
		// 1번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘 
		rec_func(1, 0);
		
		// ans가 정말 "정말 앝격값"
	
		System.out.println();
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
