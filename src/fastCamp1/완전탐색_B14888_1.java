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

public class 완전탐색_B14888_1 {

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
    

    static void rec_func(int k, int value) {
        if (k == N) {
        	//int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;
                    int new_value = value;
                    if (cand == 1) 
                    	new_value += nums[k + 1];
                    if (cand == 2) 
                    	new_value -= nums[k + 1];
                    if (cand == 3) 
                    	new_value *= nums[k + 1];
                    if (cand == 4) 
                    	new_value /= nums[k + 1];
                    rec_func(k + 1, new_value);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }
}