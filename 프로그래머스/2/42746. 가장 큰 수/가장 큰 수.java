import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {

        // 1. int 배열을 String 배열로 변환
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 2. 두 문자열을 이어 붙였을 때 더 큰 순서로 정렬
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 3. 가장 앞이 "0"이면 모든 숫자가 0이라는 뜻
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 4. 정렬된 문자열을 모두 이어 붙이기
        StringBuilder answer = new StringBuilder();

        for (String number : strNumbers) {
            answer.append(number);
        }

        return answer.toString();
    }
}