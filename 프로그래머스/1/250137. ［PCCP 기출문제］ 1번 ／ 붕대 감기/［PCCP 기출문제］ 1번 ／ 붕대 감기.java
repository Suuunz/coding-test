class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0], x = bandage[1], y = bandage[2];
        int maxHealth = health;
        int cur = health;
        int prev = 0; // 직전 공격 시각 (초기 상태는 0초)

        for (int[] attack : attacks) {
            int time = attack[0], damage = attack[1];

            // 1) 직전 공격 이후부터 이번 공격 직전까지 회복
            int gap = time - prev - 1;
            int heal = gap * x + (gap / t) * y;
            cur = Math.min(maxHealth, cur + heal);

            // 2) 공격 받기
            cur -= damage;
            if (cur <= 0) return -1;

            prev = time;
        }
        return cur;
    }
}