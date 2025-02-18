import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n + 1];
        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(score[1]);
            return;
        }

        dp[1][0] = score[1];
        dp[1][1] = score[1];

        if (n >= 2) {
            dp[2][0] = score[2];  // 첫 계단을 안 밟고 두 번째 계단으로 이동
            dp[2][1] = score[1] + score[2];  // 첫 계단을 밟고 두 번째 계단으로 이동
        }

        for (int i = 3; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i]; // 전전 계단에서 오는 경우
            dp[i][1] = dp[i - 1][0] + score[i]; // 이전 계단에서 오는 경우
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
