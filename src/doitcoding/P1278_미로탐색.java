package doitcoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1278_미로탐색 {
	//2178 
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] A; // 데이터 저장 2차원 행렬]
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken(); // 1011010101
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		BFS(0,0);
		System.out.println("A[N-1][M-1] : " + A[N-1][M-1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();		
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int now[] = queue.poll();			 
			for (int k = 0; k < 4; k++) { //상하좌우로 탐색
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				System.out.println("x,y : " + x + ", " + y);
				if (x >= 0 && y >= 0 &&  x < N && y < M) { // 배열을 넘기면 안되고
					if (A[x][y] != 0 && !visited[x][y]) { // 0이여서 갈수없거나 기방문한 곳이면 안됨
						// 이제 갈 수 있는 곳이다. 
						System.out.println("갈수 있는 곳 : " + x + "," + y);
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; // 핵심 => 동영상강의 중 2, 3, 4 로 늘려 푸는방식
						queue.add(new int[] {x, y});
					}
				}
			}
		}
	}
	

}
