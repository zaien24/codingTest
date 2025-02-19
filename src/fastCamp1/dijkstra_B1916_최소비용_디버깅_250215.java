package fastCamp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra_B1916_최소비용_디버깅_250215 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N+1];
		edges = new ArrayList[N+1];

		for (int i=1;i<=N;i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for (int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijkstra(start);
        System.out.print(dist[end]);
	}
	
	static StringBuilder sb = new StringBuilder();

	static int N, M, start, end;
	static int[] dist;
	static ArrayList<Edge>[] edges;

	//  static int[][][] bus; // 이렇게 하는게 우니 객체를 만든다. 

	static void dijkstra(int start) {
		// 모든 정점까지에 대한 거리를 무한대로 초기화 해주기 
		// 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임을 보장해야 한다.
		for (int i=1;i<=N;i++) dist[i] = Integer.MAX_VALUE; 

		//최소 힙 생성
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
		pq.add(new Info(start,0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Info info = pq.poll();

			if (dist[info.idx] != info.dist) continue;

			for (Edge e : edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to]) {
					continue;
				}

				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}

	}
	
	static class Edge {
		public int to, weight;

		public Edge(int _to, int _weight) {
			this.to = _to;
			this.weight = _weight;
		}
	}

	static class Info {
		public int idx, dist;

		public Info() {

		}

		public Info(int _idx, int _dist) {
			this.idx = _idx;
			this.dist = _dist;
		}
	}
}