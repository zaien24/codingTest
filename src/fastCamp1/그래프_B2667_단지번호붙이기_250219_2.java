import java.io.*;
import java.util.*;

public class Main {

    static int N, group_cnt; 
    static String[] A;
    static boolean[][] visit;
    static ArrayList<Integer> group;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y] = true;

        for (int k=0;k<4;k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >=  N) continue; 
            if (visit[nx][ny] || A[nx].charAt(ny) == '0') continue;
            dfs(nx,ny);
        }        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        A = new String[N];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = st.nextToken();
        }

        group = new ArrayList<>();
        visit = new boolean[N+1][N+1];

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (!visit[i][j] && A[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);

        System.out.println(group.size());
        for (int cnt : group) {
            System.out.println(cnt);
        }
    }
}