public class Main {
    static StringBuffer sb = new StringBuffer();

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void bfs(int x1, int x2, int x3) {
        Queue<State> que = new LinkedList<>();
        visit[x1][x2][x3] = true;
        que.add(new State(new int[] {x1, x2, x3}));

        while(!que.isEmpty()) {
            State st = que.poll();

            if (st.X[0] == 0) possible[st.X[2]] = true;

            for (int from=0;from<3;from++) {
                for (int to=0;to<3;to++) {
                    if (from == to) continue;
                    State nxt = st.move(from, to, limit);
                    
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        que.add(nxt);
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];

        for (int i=0;i<3;i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        possible = new int[201];
        visit = new int[201][201][201];

        bfs(0,0,limit[2]);

        for (int i=0;i<201;i++) {
            if (possible[i]) sb.append(i).append(" "); 
        }
        System.out.println(sb);

    }

    public class State {
        int[] X;

        State(int[] _X) {
            X = new int[3];

            for (int i=0;i<3;i++) {
                this.X[i] = _X[i];
            }
            
        }

        State move(int x1, int x2, int[] limit) {
            int[] nX = new int[]{x1, x2, limit[2]};

            if (X[from] + X[to] <= limit[to]) {
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            } else {
                nX[to] = limit[to] - nX[to];
                nX[from] = 
            }

            return new State(nX);
        }

    }
}