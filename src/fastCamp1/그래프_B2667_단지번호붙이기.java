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

public class 그래프_B2667_단지번호붙이기 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}}; // 
    static ArrayList<Integer> group; // 단지의 정보를 기록할 배열
    
    static void input() {
    	N = scan.nextInt();
    	a = new String[N];
    	for (int i = 0; i < N; i++) {
    		a[i] = scan.nextLine();
    	}
    	visit = new boolean[N][N];    			
    }
    
    
    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
    	// 단지에 속한 집의 개수 증가, visit 체크 하기 
    	group_cnt++;
    	visit[x][y] = true;
    	
    	// 인접한 집으로 새로운 방문하기 
    	for (int k = 0; k < 4; k++) {
    		// (x,y) -> dir[k])
    		int nx = x + dir[k][0];
    		int ny = y + dir[k][1];
    		if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 실제 존재하는 격자인지 확인
    		if (a[nx].charAt(ny) == '0') continue;
    		if (visit[nx][ny]) continue;
    		dfs(nx, ny);
    	}
    }
    
    private static void pro() {
    	group = new ArrayList<>();
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (!visit[i][j] && a[i].charAt(j) == '1') { // 아직 방문을 하지 않고, 1이 써져 있는 것을 만난다면,
    				// 갈 수 있는 칸인데, 이미 방문처리 된, 즉 새롭게 만난 단지의 경우 
    				group_cnt = 0; // 집의 개수
    				dfs(i, j);
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
    
    public static void main(String[] args) {
    	input();
    	pro();
    	    	
    }
   
	

	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}