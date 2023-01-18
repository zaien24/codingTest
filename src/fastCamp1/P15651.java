package fastCamp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15651 {

	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] selected;
	
	private static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M + 1];
		
	}
	
	// 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것!
	// 아직 M 개를 고르지 않음 => k 번쨰부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다. 
	private static void rec_func(int k) {
		
		System.out.println("분기 처리 전");
		System.out.println("분기 처리 전 k : " + k);
		
		if (k == M + 1) { // 다 골랐다!
			System.out.println("분기 처리 후1");
			System.out.println("분기 처리 후1 k : " + k);
			System.out.println("분기 처리 후1 M : " + M);
			
			// selected[1...M] 배열이 새롭게 탐색된 겨로가 
			for (int i=1;i<=M;i++) {
				System.out.println("분기 처리 후1 i : " + i);
				sb.append(selected[i]).append(' ');		
			}
			sb.append('\n');			
		} else {
			System.out.println("분기 처리 후2");
			for (int cand=1;cand<=N;cand++) {
				System.out.println("분기 처리 후2 cand : " + cand);
				System.out.println("분기 처리 후2 selected : " + selected[k]);
				selected[k] = cand;
				// k+1 번 ~ M 번 을 모두 탐색하는 일을 해야 하는 상황
				System.out.println("분기 처리 후2 k: " + k);
				System.out.println("분기 처리 후2 selected2 : " + selected[k]);				
				rec_func(k+1);
				System.out.println("재귀 끝");
				selected[k] = 0;
			}
		}
		
	}
		
	public static void main(String[] args) {
		input();
		
		// 1번쨰 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘 
		rec_func(1);
		System.out.println(sb.toString());		
	}

	// 입출력 클래스 
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