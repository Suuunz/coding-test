class Solution {
    public int solution(int n) {
        int a = 0; // F(0)
        int b = 1; // F(1)

        for (int i = 2; i <= n; i++) {
            int next = (a + b) % 1234567;

            a = b;
            b = next;
        }

        return b;
    }
}