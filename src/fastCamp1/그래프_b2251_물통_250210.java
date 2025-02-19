public class Main {

    static int[] limit;
    
    static class State {
        int[] X;    
        State(int[] _X) {
            X = new int[3];
            for (int i = 0; i < 3; i++) {
                X[i] = _X[i];
            }
        }

        State move(int from, int to, int[] limit) {
        // from 이 먼저 차냐? to가 먼저 차냐로 나뉜다.
            int[] nX = new int[] {X[0], X[1], X[2]};

            if (X[from] + X[to] <= limit[to]) {
                nx[to] = nx[from] + nx[to];
                nx[from] = 0;
            } else {
                nx[from] -= limit[to] - nX[to];
                nX[to] = limit[to];
            }
            return new State(nX);
        }
        
        }
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> que = new LinkedList<>();
        visit[x1][x2][x3] = true;

        que.add(new State(new int[] {x1, x2, x3}));

        while(!que.isEmpty()) {
            State st = que.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    // i 번 물통에서 j 번 물통으로 물을 옮긴다. 
                    State nxt = st.move(from, to, limit);

                    if (!visit[nxt.X[0]][nxt.X[1]]][nxt.X[2]]]) {
                        visit[nxt.X[0]][nxt.X[1]]][nxt.X[2]] = true;
                        que.add(nxt);
                    }
                }
            }
        }

    }

    public static void main(Strig[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];

        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0, 0, limit[2]);

    }
}