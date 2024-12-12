package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 완전탐색_B14888_2 {

	static StringBuilder sb = new StringBuilder();
	
	static int N, max, min;
	static int[] nums, operators, order;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		N = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        operators = new int[5];
        
		st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= 4; i++) operators[i] = Integer.parseInt(st.nextToken());
    	
    	max = Integer.MIN_VALUE;
    	min = Integer.MAX_VALUE;
    	
    	rec_func(1, nums[1]);
    	sb.append(max).append('\n').append(min);
    	System.out.println(sb.toString());
    }
    
    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k, int value) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;
                    int new_value = calculator(value, cand, nums[k + 1]);
                    rec_func(k + 1, new_value);
                    operators[cand]++;
                }
            }
        }
    }

     
    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2){
        // value, order[i], num[i+1]
        if (operator == 1) // +
            return operand1 + operand2;
        else if (operator == 2) // -
            return operand1 - operand2;
        else if (operator == 3) // *
            return operand1 * operand2;
        else // /
            return operand1 / operand2;
    }
}