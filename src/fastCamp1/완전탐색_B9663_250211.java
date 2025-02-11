public class Main {


    static int N, result;
    static int[] col;

    public static booelean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) continue;
        if (r1 - c1 == r2 - c2) continue;
        if (r2 + c2 == r2 + c2) continue;
        return true; 
    } 

    public static boolean valid_check() {

        

        return true;
    }

    public static void rec_func(int k) {
        if (k == N) {
            if(valid_check)
            result++;
        } else {
            for (int i = 1; i < N; i++) {
                    for (int j = 1; j < N; j++)
                        col[i] = j;
                        rec_func(k + 1);
                        col[i] = 0;
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