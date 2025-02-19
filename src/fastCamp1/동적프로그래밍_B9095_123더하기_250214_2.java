import java.io.*;
import java.util.*;

public class Main {
    static int[] Dy;

    static void preprocess() {
        Dy = new int[15];

        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for (int i=4;i<=11;i++) {
            Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        preprocess();
        int T = Integer.parseInt(st.nextToken());

        for (int i=1;i<=T;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(Dy[n]);
        }

    }
}