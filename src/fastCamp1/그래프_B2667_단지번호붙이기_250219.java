public class Main {

    static int N, group_cnt;
    static int[][] adj;
    static boolean[][] visited;
    static int[][] chk;
    static int nx, ny;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    static void bfs(int x, int y) {
        Queue<Integer, Integer> que = new LinkedList<>();
        que.add(x,y);
        visited[x][y] = true;

        while (!que.isEmpty()) {
            chk = que.poll();

            for (int k=0;k<4;k++) {
                nx = x + dir[k][0];
                ny = y + dir[k][1];

                if (adj[nx][ny] == 0) {
                    break;
                }
                if (visited[nx][ny]) continue;

                if (adj[nx][ny] == 1) {
                    group_cnt++;
                }
            }

            que.add(nx,ny);
            visited[nx][ny] = true;
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nexToken());

        adj = new int[N+1][N+1];

        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        group_cnt = 0;


    }
}