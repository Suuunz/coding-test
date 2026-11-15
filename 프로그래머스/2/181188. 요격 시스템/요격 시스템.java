import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        // 끝점(e) 기준 오름차순 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int lastShot = -1; // 마지막 요격 미사일이 커버하는 경계 (e 바로 앞에서 발사)

        for (int[] t : targets) {
            // 시작점이 마지막 발사 경계 이상이면 기존 요격으로 못 잡음 (개구간)
            if (t[0] >= lastShot) {
                answer++;
                lastShot = t[1]; // e - ε 지점에서 발사한다고 생각
            }
        }
        return answer;
    }
}