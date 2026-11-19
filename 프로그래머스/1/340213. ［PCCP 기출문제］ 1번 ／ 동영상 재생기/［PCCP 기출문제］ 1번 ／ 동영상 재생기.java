class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toSec(video_len);
        int cur = toSec(pos);
        int opS = toSec(op_start);
        int opE = toSec(op_end);

        // 시작 위치가 오프닝 구간이면 먼저 건너뛰기
        if (opS <= cur && cur <= opE) cur = opE;

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else {
                cur = Math.min(len, cur + 10);
            }
            // 이동한 뒤에도 오프닝 구간인지 확인
            if (opS <= cur && cur <= opE) cur = opE;
        }

        return String.format("%02d:%02d", cur / 60, cur % 60);
    }

    private int toSec(String t) {
        String[] p = t.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }
}