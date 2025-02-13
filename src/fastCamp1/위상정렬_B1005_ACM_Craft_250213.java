public class Main {

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    public static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i=1;i<=N;i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                T_done[i] = T[i];
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
                T_done[y] = Math.max(T_done[y], T_done[x] + T[y]); 
            }
        }
        int W = Integer.parseInt();
        System.out.println(T_done[W]);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        indeg = new it[N+1];

        T = new int[N+1];
        T_done = new int[N+1];

        for (int i-1;i<=N;i++) {
            adj[i] = new ArrayList<>();
            T[i] = Integer.parseInt();
        }

        for (int i=0;i<M;i++) {
            int x = Integer.parseInt();
            int y = Integer.parseInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    pro();

}