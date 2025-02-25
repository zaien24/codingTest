	import java.io.*;
	import java.util.*;

	public class Main {
		static StringBuilder sb = new StringBuilder();

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

		static void rec_func(int k) {
			if (k == N) {
				int value = calulator();
				
				max = Math.max(value, max);
				min = Math.min(value, min);
			} else {
				for (int i=1;i<=4;i++) {
					if(operators[i] >= 1) {
						operators[i]--;
						order[k] = i;
						rec_func(k+1);
						operators[i]++;
						order[k] = 0;
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

			rec_func(1);
			sb.append(max).append("\n").append(min);
			System.out.println(sb.toString());

		}
	}