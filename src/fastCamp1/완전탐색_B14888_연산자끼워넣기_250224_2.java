	import java.io.*;
	import java.util.*;

	public class Main {
		static StringBuffer sb = new StringBuffer();

		static int N, max, min;
		static int[] nums, operators, order;

		static int calulator() {
			int value = nums[1];

			for (int i=1;i<=N-1;i++) {
				if (order[i] == 1) {
					value += nums[i+1];
				}

				if (order[i] == 2) {
					value -= nums[i+1];
				}

				if (order[i] == 3) {
					value *= nums[i+1];
				}

				if (order[i] == 4) {
					value /= nums[i+1];
				}
			}
			return value;
		}

		static int operator(int operand1, int operator, int operand2) {
			if (operator ==1) 
				return operand1 + operand2;
				else if (operator == 2) // -
					return operand1 - operand2;
				else if (operator == 3) // *
					return operand1 * operand2;
				else // /
					return operand1 / operand2;
		}

		static void rec_func(int k, int value) {
			if (k == N) {
				//int value = calulator();
				max = Math.max(max, value);
				min = Math.min(min, value);
			} else {
				for (int cand=1;cand<5;cand++) {
					if (operators[cand] >= 1) {
						operators[cand]--;
						order[k] = cand;

						// if (order[k] == 1) {
						// 	new_value += nums[k+1];
						// } else if (order[k] == 2) {
						//  	new_value -= nums[k+1];
						// } else if (order[k] == 3) {
						// 	new_value *= nums[k+1];
						// } else if (order[k] == 4) {
						// 	new_value /= nums[k+1];
						// }

						rec_func(k+1, operator(value, cand, nums[k+1]));
						operators[cand]++;
					}
				}
			}
		}

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			nums = new int[N+1];
			operators = new int[5];
			order = new int[N+1];

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i=1;i<=N;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i=1;i<=4;i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}

			rec_func(1, nums[1]);
			sb.append(max).append("\n").append(min);
			System.out.println(sb.toString());

		}
	}