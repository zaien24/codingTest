public class Main {

	static int N, M; 
	static int[] dist;
	static ArrayList<Edge>[] edges;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N+1];
		edges = new ArrayList[N+1];

		for (int i=1;i<=N; i++) {
			edges[i] = new ArrayList<Edge>();
		}
		
		for (int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edges[from].add(new Edge(to, weight));
		}

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);
		System.out.println(dist[end]);
		
	}

	static void dijkstra(int start) {
		for (int i=1;i<=N;i++) dist[i] = Integer.MAX_VALUE;

		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
		pq.add(new Info(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Info info = pq.poll();

			if (dist[info.idx] <= info.dist) {
				continue;
			}

			for (Edge e : Edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to]) {
					continue;
				}
				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}
	
	public class Edge {
		int to, weight;

		public Edge() {

		}

		public Edge(_to, _weight) {
			this.to = _to;
			this.weight = _weight;
		}
	}

	public class Info {
		int idx, dist;
		
		public Info() {

		}
		public Info(_idx, _dist) {
			this.idx = _idx;
			this.dist = _dist;
		}
	}
}