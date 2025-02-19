import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M,V;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()) {
            int x = que.poll();

            sb.append(x).append(" ");
            for (int y : adj[x]) {
                if (visited[y]) continue; 
                que.add(y);
                visited[y] = true;
            }
        }
    }

    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");
        for (int y : adj[x]) {
            if (visited[y]) continue; 
            dfs(y);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];

        for (int i=1;i<=N;i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            adj[x].add(y);
            adj[y].add(x);
        }

        for (int i=1;i<=N;i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++) visited[i] = false;
        bfs(V); 
        System.out.println(sb);
    }
}