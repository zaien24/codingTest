package fastCamp1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프_B2606_바이러스 {
	static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
	
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    
    static void input() {
    	N = scan.nextInt();
    	M = scan.nextInt();
    	adj = new ArrayList[N + 1];
    	for (int i = 1; i <= N; i++) {
    		adj[i] = new ArrayList<>();
    	}
    	for (int i = 0; i < M; i++) {
    		int x = scan.nextInt();
    		int y = scan.nextInt();
    		adj[x].add(y);
    		adj[y].add(x);
    		
    	}
    }
    static void bfs(int start) {
    	Queue<Integer> que = new LinkedList<>();
    	
    	que.add(start);
    	visit[start] = true;
    	
    	while (!que.isEmpty()) {
    		int x = que.poll();
    		
    		for (int y: adj[x]) {
    			if (visit[y]) continue;
    			
    			que.add(y);
    			visit[y] = true;
    		}
    	}
    	
    }
    
    static void pro() {
    	visit = new boolean[N + 1];
    	bfs(1);
    	int ans = 0;
    	for (int i = 2; i <= N; i++) {
    		if (visit[i]) {
    			ans++;
    		}
    	}
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