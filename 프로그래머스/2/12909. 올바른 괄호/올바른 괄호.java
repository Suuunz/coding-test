class Solution {
    boolean solution(String s) {
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                open--;
                if (open < 0) return false;
            }
        }

        return open == 0;
    }
}