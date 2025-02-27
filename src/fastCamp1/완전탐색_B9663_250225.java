import java.util.*;
import java.io.*;

public class Main {

    static int N, ans;

    static int[] col;
    
    static boolean chk_attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) {
            return true;
        }
        if (r1+c1 == r2+c2) {
            return true;
        }
        if (r1-c1 == r2-c2) {
            return true;
        }
        return false;
    }

    static boolean chk_validity() {
        for (int i=1;i<=N;i++) {
            for (int j=1;j<i;j++) {
                if (chk_attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static void rec_func(int row) {
        if (row == N+1) {
            if (chk_validity()) {
                ans++;
            }
        } else {
            for (int c=1;c<=N;c++) {
                boolean possiable = true;
                // valid check (row, c)
                for (int i=1;i<=row-1;i++) {
                    // (i, col[i])
                    if (attackable(row, c, i, col[i])) {
                        possiable = false;
                        break;
                    }
                }
                if (possiable) {
                    col[row] = c;
                    rec_func(row+1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        N = sc.nextInt();

        col = new int[N+1];

        rec_func(1);
        System.out.println(ans);
    }
}