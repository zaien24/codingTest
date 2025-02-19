import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");

        for (int y=1; y<=N;y++) {
            if (visit[y]) continue; 
            if (adj[x][y] == 0) continue;
            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visit[start] = true;

        
        while(!que.isEmpty()){
            int x = que.poll();

            sb.append(x).append(" ");

            for (int y=1;y<=N;y++) {
                if (visit[y]) continue;
                if (adj[x][y] == 0) continue;
                que.add(y);
                visit[y] = true;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());


        adj = new int[N+1][N+1];

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = adj[y][x] = 1;
        }

        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visit = new boolean[N+1];
        bfs(V); 
        System.out.println(sb);
    }
}