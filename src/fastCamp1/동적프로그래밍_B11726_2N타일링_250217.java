import java.io.*;
import java.util.*;


public class Main {

    static int result = 0;
    static int[] Dy;
    static int N;

    static void prePro() {

        Dy = new int[N+1];

        Dy[1] = 1;
        Dy[2] = 2;

        for (int i=3;i<=N;i++) {
            Dy[i] = (Dy[i-1] + Dy[i-2]) % 10007;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        prePro();

        int ans = Dy[N]%10007;
        System.out.println(ans);
    }
}