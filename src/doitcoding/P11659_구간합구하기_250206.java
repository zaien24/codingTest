import java.io.*;
import java.util.*;

public class Main {
    static StringBuffer sb = new StringBuffer();
    
    static int N, M; 
    static int[] A;
    static long[] S;
    
    public static void main(String[] arags) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        S = new long[N + 1];
        S[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
        	
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i-1] + A[i];
        }

        for (int m = 1; m <= M; m++) {
        	st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(S[j] - S[i-1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}