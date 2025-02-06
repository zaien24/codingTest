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

public class 그래프_b2251_물통_250106 {
    static StringBuilder sb = new StringBuilder();
    
    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	    	   
        Limit = new int[3];
    	for (int i = 0; i < 3; i++) {
    		Limit[i] = Integer.parseInt(st.nextToken());
    		
    	}
    	visit = new boolean[205][205][205];
    	possible = new boolean[205];
    	
    	bfs(0, 0, Limit[2]);
    	for (int i = 0; i <= 200; i++) {
    		if (possible[i]) {
    			sb.append(i).append(' ');
    		}    		
    	}
    	System.out.println(sb);
    }
    
    static void bfs(int x1, int x2, int x3) {
    	Queue<State> Q = new LinkedList<>();
    	visit[x1][x2][x3] = true;
    	Q.add(new State(new int[] {x1, x2, x3}));
    	
    	while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    // i 번 물통에서 j 번 물통으로 물을 옮긴다.
                    State nxt = st.move(from, to, Limit);

                    // 만약 바뀐 상태를 탐색한 적이 없다면
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }
    
    static class State {
    	int[] X;
    	State(int[] _X) {
    		X = new int[3];
    		for (int i = 0; i < 3; i++) {
    			X[i] = _X[i];
    		}
    	}
    	
    	State move(int from,int to,int[] Limit){
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] nX = new int[]{X[0], X[1], X[2]};
            if (X[from] + X[to] <= Limit[to]){  // 만약 from 을 전부 부을 수 있다면
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            }else{  // from 의 일부만 옮길 수 있는 경우
                nX[from] -= Limit[to] - nX[to];
                nX[to] = Limit[to];
            }
            return new State(nX);
        }
    	
    }
}