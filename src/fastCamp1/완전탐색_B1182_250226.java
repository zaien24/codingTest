import java.io.*;
import java.util.*;

public class Main {
    static int N, S, ans;
    static int[] nums;

    static void rec_func(int k, int value) {
        if (k == N) {  // k == N에서 종료해야 배열 범위를 벗어나지 않음
            if (value == S) {
                ans++;
            }
            return;
        }

        // 현재 원소를 선택하는 경우
        rec_func(k+1, value + nums[k]);
        
        // 현재 원소를 선택하지 않는 경우
        rec_func(k + 1, value);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N]; // 배열 크기 초기화

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        rec_func(0, 0);  // 첫 번째 원소부터 시작해야 함

        if (S == 0) {
            ans--; // 공집합 제외
        }

        System.out.println(ans);
    }
}
