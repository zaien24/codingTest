package doitcoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수2 {

	//방문 기록 저장 배열
	static boolean visited[];
	//그래프 데이터 저장 인접 리스트
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		A = new ArrayList[n+1];
		
		for (int i = 0; i < n + 1; i++) { // A 인접 리스트의 각 ArrayList 초기화하기 
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) { // A 인접 릿르트에 그래프 데이터(엣지) 저장하기
			st = new StringTokenizer(bf.readLine());	
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println("count : " + count);
	}

	private static void DFS(int v) {
		if (visited[v]) { // 현재 노드가 방문노드 이면 
			return;
		}
		visited[v] = true;
		
		//현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기
		for (int i : A[v]) {
			if (!visited[i]) {
				DFS(i);				
			}
		}
	}

}
