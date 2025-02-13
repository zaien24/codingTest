public class Main {

    static int N, M; 
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i=1;i<=N;i++) {
            if (indeg[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(Syste.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N+1];
        indeg = new int[N+1];

        for (int i=1;i<=N;i++) {
            adj[i] = new ArrayList<>();
        } 

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }

        pro();

    }
}