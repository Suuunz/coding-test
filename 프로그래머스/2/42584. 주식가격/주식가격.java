import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        // 아직 가격이 떨어지지 않은 시점의 인덱스를 저장
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            /*
             * 현재 가격 prices[i]가
             * 스택 맨 위 시점의 가격보다 낮다면
             * → 그 시점의 가격이 지금 떨어진 것
             */
            while (!stack.isEmpty()
                    && prices[stack.peek()] > prices[i]) {

                int index = stack.pop();

                // index 시점부터 i 시점까지 걸린 시간
                answer[index] = i - index;
            }

            // 현재 시점은 아직 가격이 떨어졌는지 알 수 없으므로 스택에 저장
            stack.push(i);
        }

        /*
         * 끝까지 스택에 남아 있는 인덱스들은
         * 마지막까지 가격이 떨어지지 않은 경우
         */
        while (!stack.isEmpty()) {

            int index = stack.pop();

            // 마지막 시점까지 유지된 시간
            answer[index] = (n - 1) - index;
        }

        return answer;
    }
}