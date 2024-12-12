package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬_B1015_수열정렬_241212 {
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

    	/**
    	 * @param idx A배열의 idx 위치를 기억하는 변수 
    	 * @param num A[idx]의 원래 
    	 */
        public int num, idx;

        @Override
        public int compareTo(Elem other) {
        	//TODO
        	// 정렬 조건에 맞게 정렬하기
        	// 1. num 의 비내림차순
        	// 2. num이 같으면 idx 오름차순
        	if (num != other.num) return num - other.num;
        	
            //return num - other.num;
        	return idx - other.idx;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		N = Integer.parseInt(st.nextToken());
        B = new Elem[N];
        P = new int[N];
        
    	st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = Integer.parseInt(st.nextToken());
            B[i].idx = i;
            
           System.out.println(Arrays.toString(B));
           System.out.println("B");
        }
		
     // TODO : B 배열 정렬하
        Arrays.sort(B);
        
        // TODO : B 배열의 값을 이용해서 P 배열 채우
        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx].idx] = b_idx;
        }
        
        //TODO : P 배열 출력하
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}