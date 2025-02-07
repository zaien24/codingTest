import java.io.*;
import java.util.*;

public class Main {

    static int N; 
    static String[] A;
    static boolean[][] visit;
    static ArrayList<Integer> group;
    static int group_cnt;
    static int[][] dir = {{-1, 0}, {1, 0}, {0,1}, {0, -1}};

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        group_cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0]; 
            int ny = y + dir[k][1];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (A[nx].charAt(ny) == '0') continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokeninzer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = st.nextToken();
        }

        visit = new boolean[N+1][N+1];

        group = new ArrayList<>();
        
    
        for  (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && A[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);
        System.out.println(group.size());
        for (int i = 0; i < group.size(); i++) {
            System.out.println(group[i]);
        }

    }
}