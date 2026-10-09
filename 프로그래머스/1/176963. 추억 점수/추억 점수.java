import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 1. 이름 → 그리움 점수 매핑
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }

        // 2. 사진마다 점수 합산
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String person : photo[i]) {
                sum += scoreMap.getOrDefault(person, 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}