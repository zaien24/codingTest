public class Main {


    static int N, result;
    static int[] col;

    public static booelean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;;
        if (r1 - c1 == r2 - c2) return true;
        if (r2 + c2 == r2 + c2) return true;
        return false; 
    } 

    public static boolean valid_check() {
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <i; j++) {
                if (attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }

        return true;
    }

    public static void rec_func(int k) {
        if (k == N) {
            if(valid_check())
            result++;
        } else {
            for (int i = 1; i < N; i++) {
                col[k] = i;
                rec_func(k + 1);
                col[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        col = new int[N];


        result = 0;

        rec_func(1);

        System.out.println(result);

    }
}