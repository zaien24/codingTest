import java.io.*;
import java.util.*;

public class Main {
    static StringBuffer sb = new StringBuffer();
    
    static int N, M; 
    static int[] A, S;

    public static void proc() {
        Scanner sc = new Scanner(System.in);

        for (int m = 1; m <= M; m++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            sb.append(S[j] - S[i-1]);
            sb.append("\n");
        }
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        S = new int[N];
        S[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            S[i] += A[i];
        }
    }

    public static void main(String[] arags) throws Exception {
        input();    
        proc();
        System.out.println(sb.toString());
    }
}