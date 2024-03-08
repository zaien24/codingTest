package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class C15649 {
	
	static int[] selected;
    static int[] used;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    
    public static void input() {
        Scanner sc = new Scanner(System.in);        
        N = sc.nextInt();
        M = sc.nextInt();
        
        selected = new int[M + 1];
        used = new int[N + 1];        
    }
    
    public static void rec_func(int k) {
        if (k == M + 1) {
            for (int i=1; i<=M;i++) {
                sb.append(selected[i]).append(' ');                
            }
            sb.append("\n");
        }
        else {
            for (int cand = 1; cand <= N; cand++) {
                if (used[cand] == 1) continue;                     
                
                selected[k] = cand; used[cand] = 1;
                System.out.println("selected : " + Arrays.toString(selected));
                System.out.println("used : " + Arrays.toString(used));
                rec_func(k+1);
                selected[k] = 0;     used[cand] = 0;
                System.out.println("rec selected : " + Arrays.toString(selected));
                System.out.println("rec used : " + Arrays.toString(used));
            }
        }
    }
    
    
    public static void main(String args[]) {
        input();        
        rec_func(1);        
        System.out.println(sb.toString());
    }

}
