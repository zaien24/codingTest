package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14888 {

	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
 

    
	private static void input() {	
		N = scan.nextInt();
		nums = new int[N + 1];
		operators = new int[5];
		order = new int[N + 1];
		for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
		for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;			
	}
	
	private static int calculator() {
		// nums, order
		int value = nums[1];
		for (int i=1;i<=N-1;i++) {
			// value, order[i], nums[i+1]
			if (order[i] == 1) // +
				value = value + nums[i+1];
			if (order[i] == 2) // -
				value = value - nums[i+1];
			if (order[i] == 3) // *
				value = value * nums[i+1];
			if (order[i] == 4)  // /
				value = value / nums[i+1];
		}
		return value;
	}
	
	static int N, max, min;
	static int[] nums, operators, order;
	
	// order[1...N-1] 에 연산자들이 순서대로 저장될 것이다. .
	private static void rec_func(int k) {
		if (k == N) {
			// 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);			
		} else {
			// k 번째 연산자는 무엇을 선택할 것인가?
			for (int cand = 1; cand <= 4; cand++) {
				// 4 가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출하기
				System.out.println("k : " + k);
				System.out.println("cand : " + cand);
				System.out.println("operators[cand] : " + operators[cand]);
				if (operators[cand] >= 1) {
					System.out.println("operators.toString : " + Arrays.toString(operators));
					System.out.println("order[k] : " + Arrays.toString(order));
					operators[cand]--;
					order[k] = cand;
					System.out.println("operators.toString cand : " + Arrays.toString(operators));
					System.out.println("order[k] cand : " + Arrays.toString(order));
					rec_func(k+1);
					operators[cand]++; 
					order[k] = 0;
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		input();
		
		rec_func(1);
		sb.append(max).append('\n').append(min);
		System.out.println(sb.toString());

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