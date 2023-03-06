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

public class 그래프_B14502_연구소 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    
    static int N, M, B, ans;
    static int[][] A, blank;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	A = new int[N + 1][M+1];
    	blank = new int[N*M+1][2];
    	visit = new boolean[N+1][M+1];
    	for (int i = 1; i <= N; i++) {
    		for (int j = 1; j <= M; j++) {
    			A[i][j] = scan.nextInt();
    		}
    	}
    }
    
    static void bfs() {
    	Queue<Integer> Q = new LinkedList<>();
    	
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
    
    static void pro() {
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