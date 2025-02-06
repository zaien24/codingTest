package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프_B14502_연구소_250107 {
	static StringBuilder sb = new StringBuilder();
	
    static int N, M, B, ans;
    static int[][] A, blank;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
 // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;
                if (A[i][j] == 2) {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정
        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (A[nx][ny] != 0) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }

        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        int cnt = 0;
        for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) if (A[i][j] == 0 && !visit[i][j]) cnt++;
        ans = Math.max(ans, cnt);
    }
    
    static void dfs(int idx, int selected_cnt) {
    	if (selected_cnt == 3) {
    		bfs();
    		return;
    	}
    	if (idx > B) return;
    	
    	A[blank[idx][0]][blank[idx][1]] = 1;
    	dfs(idx+1, selected_cnt+1);
    	
    	A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	A = new int[N + 1][M+1];
    	blank = new int[N*M+1][2];
    	visit = new boolean[N+1][M+1];
    	
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= M; j++) {
    			A[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= M; j++) {
    			if (A[i][j] == 0) {
    				B++;
    				blank[B][0] = i;
    				blank[B][1] = j;
    			}
    		}
    	}
    	dfs(1, 0);
    	
    	System.out.println(ans);
    	    	
    }
}