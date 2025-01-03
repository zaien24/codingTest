package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 그래프_B2667_단지번호붙이기_250103 {
static StringBuffer sb = new StringBuffer();
    
    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static ArrayList<Integer> group;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        a = new String[N];
        
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }
        visit = new boolean[N][N];
        
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1' ) {
                    group_cnt = 0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }
        
        // 찾은 단지의 정보를 출력하기 
    	Collections.sort(group);
    	sb.append(group.size()).append('\n');
    	for (int cnt : group ) {
    		sb.append(cnt).append('\n');
    	}
    	System.out.println(sb.toString());
    }
    
    public static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y] = true;
        
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (a[nx].charAt(ny) == '0') continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }
}   