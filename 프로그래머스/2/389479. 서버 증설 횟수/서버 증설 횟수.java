class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int current = 0;

        int[] added = new int[24];

        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                current -= added[i - k];
            }

            int need = players[i] / m;

            if (current < need) {
                int add = need - current;

                added[i] = add;
                current += add;
                answer += add;
            }
        }

        return answer;
    }
}