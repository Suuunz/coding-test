import java.util.*;

class Solution {
    List<int[]>[] graph;
    int n, k, answer;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        answer = 1;

        dfs(infected, 0, 0, 1);
        return answer;
    }

    void dfs(boolean[] infected, int depth, int prev, int cnt) {
        answer = Math.max(answer, cnt);
        if (depth == k) return;

        for (int type = 1; type <= 3; type++) {
            if (type == prev) continue;

            boolean[] next = infected.clone();
            int nextCnt = spread(next, type);
            if (nextCnt == cnt) continue;

            dfs(next, depth + 1, type, nextCnt);
        }
    }

    int spread(boolean[] infected, int type) {
        Deque<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                q.add(i);
                cnt++;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : graph[cur]) {
                if (next[1] != type || infected[next[0]]) continue;
                infected[next[0]] = true;
                cnt++;
                q.add(next[0]);
            }
        }
        return cnt;
    }
}