public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, result;
    static int[] a, cnt;
    
    public static void main(String[] args) {
        BufferdReader br = new BufferedReader(new InputStreamReader(System.in));
        StirngTokenizer st = new StringTokenzier(br.readLine());

        N = Integer.parseInt(st.nextToken());
        a = new int[N+1];
        cnt = new int[100000+1]

        for (int i=1;i<=N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int L=1,R=0; L<=N;L++) {
            while (R+1<=N && cnt[A[R+1]] == 0) {
                R++;
                cnt[A[R]]++;
            }
            result += R - L + 1;

            cnt[A[L]]--;
        }


        sb.append(result);

        System.out.println(sb.toString());

    }
}