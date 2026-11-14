class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int m = n - 1;                       // 번들을 살 수 있는 스테이지 수
        int best = Integer.MAX_VALUE;
        int[] cnt = new int[n];

        for (int mask = 0; mask < (1 << m); mask++) {
            java.util.Arrays.fill(cnt, 0);
            long total = 0;

            // 구매한 번들: 가격 더하고 힌트권 개수 누적
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    total += hint[i][0];
                    for (int j = 1; j < hint[i].length; j++) cnt[hint[i][j] - 1]++;
                }
            }

            // 각 스테이지는 가진 힌트권을 최대(n-1장까지) 사용
            for (int i = 0; i < n; i++) total += cost[i][Math.min(cnt[i], n - 1)];

            best = (int) Math.min(best, total);
        }
        return best;
    }
}