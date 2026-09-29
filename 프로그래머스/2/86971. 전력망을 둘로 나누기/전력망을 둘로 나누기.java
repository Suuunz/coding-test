import java.util.*;

class Solution {

    public int solution(int n, int[][] wires) {

        // 두 전력망의 송전탑 개수 차이의 최솟값
        int answer = n;

        // 모든 전선을 하나씩 끊어본다.
        for (int cut = 0; cut < wires.length; cut++) {

            // 인접 리스트 생성
            List<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            // cut 번째 전선만 제외하고 연결
            for (int i = 0; i < wires.length; i++) {

                // 현재 끊어볼 전선이면 건너뛴다.
                if (i == cut) {
                    continue;
                }

                int a = wires[i][0];
                int b = wires[i][1];

                graph[a].add(b);
                graph[b].add(a);
            }

            // 전선을 하나 끊으면 무조건 2개의 트리가 된다.
            // 1번 송전탑이 속한 트리의 크기를 구한다.
            int count = bfs(1, graph, n);

            // 한쪽이 count개라면 다른 쪽은 n - count개
            // 두 전력망의 송전탑 개수 차이
            int diff = Math.abs(count - (n - count));

            // 가장 작은 차이 저장
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    // start 송전탑과 연결되어 있는 송전탑 개수를 BFS로 계산
    private int bfs(int start, List<Integer>[] graph, int n) {

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // 현재 송전탑 개수 포함
            count++;

            // 현재 송전탑과 연결된 송전탑 확인
            for (int next : graph[current]) {

                // 아직 방문하지 않았다면 방문
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return count;
    }
}