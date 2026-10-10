
import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        // 1. 알파벳 26개의 최소 입력 횟수를 저장할 배열
        int[] minPress = new int[26];

        // 아직 입력할 수 없는 문자라는 의미로 최댓값 설정
        Arrays.fill(minPress, Integer.MAX_VALUE);

        // 2. 모든 키를 탐색하면서 최소 입력 횟수 계산
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {

                // 문자를 배열 인덱스로 변환 (A=0, B=1, ...)
                int index = key.charAt(i) - 'A';

                // i번째 문자 입력에는 i+1번 눌러야 함
                // 기존 횟수와 비교해서 더 작은 값 저장
                minPress[index] = Math.min(
                    minPress[index], i + 1
                );
            }
        }

        // 3. 각 target의 최소 입력 횟수 계산
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;

            for (char c : targets[i].toCharArray()) {
                int index = c - 'A';

                // 입력할 수 없는 문자가 있다면 -1
                if (minPress[index] == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }

                // 해당 문자의 최소 입력 횟수를 더함
                sum += minPress[index];
            }

            answer[i] = sum;
        }

        return answer;
    }
}
