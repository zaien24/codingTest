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

	// 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수 
	private static int calculator(int operand1, int operator, int operand2) {
		// nums, order[i], num[i + 1]		
		if (operator == 1) // +
			return operand1 + operand2;
		else if (operator == 2) // -
			return operand1 - operand2;
		else if (operator == 3) // *
			return operand1 * operand2;
		else  // /
			return operand1 / operand2;
	}
	
	static int N, max, min;
	static int[] nums, operators, order;
	
	// order[1...N-1] 에 연산자들이 순서대로 저장될 것이다. .
	private static void rec_func(int k, int value) {
		if (k == N) {
			// 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
			//int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);			
		} else {
			// k 번째 연산자는 무엇을 선택할 것인가?
			for (int cand = 1; cand <= 4; cand++) {
				// 4 가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출하기
				if (operators[cand] >= 1) {					
					operators[cand]--;
					order[k] = cand;
//					int new_value = value;
					int new_value = calculator(value, cand, nums[k + 1]);
//					if (cand == 1)
//						new_value += nums[k + 1];
//					if (cand == 2)
//						new_value -= nums[k + 1];
//					if (cand == 1)
//						new_value *= nums[k + 1];
//					if (cand == 1)
//						new_value /= nums[k + 1];					
					//rec_func(k+1, new_value);
					rec_func(k+1, calculator(value, cand, nums[k + 1]));
					operators[cand]++; 
					order[k] = 0;					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		input();
		
		//rec_func(1);
		rec_func(1, nums[1]);
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