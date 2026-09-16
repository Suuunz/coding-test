import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;

        // 1. 이름 -> 인덱스 매핑
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(friends[i], i);
        }

        // 2. giftCount[i][j] : i가 j에게 준 선물 수
        //    giftIndex[i]    : i의 선물 지수 (준 선물 - 받은 선물)
        int[][] giftCount = new int[n][n];
        int[] giftIndex = new int[n];

        // 3. 선물 기록 정리
        for (String gift : gifts) {
            String[] names = gift.split(" ");
            int giver = indexMap.get(names[0]);
            int receiver = indexMap.get(names[1]);

            giftCount[giver][receiver]++;
            giftIndex[giver]++;
            giftIndex[receiver]--;
        }

        // 4. 사람마다 다음 달에 받을 선물 수 계산
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (giftCount[i][j] > giftCount[j][i]) {
                    // i가 j에게 더 많이 줬다면 i가 받는다
                    count++;
                } else if (giftCount[i][j] == giftCount[j][i]
                        && giftIndex[i] > giftIndex[j]) {
                    // 주고받은 수가 같다면 선물 지수가 큰 i가 받는다
                    count++;
                }
            }

            // 5. 최댓값 갱신
            answer = Math.max(answer, count);
        }

        return answer;
    }
}