import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String name : callings) {
            int cur = rank.get(name);       // 불린 선수의 현재 등수
            String front = players[cur - 1]; // 바로 앞 선수

            // 배열에서 자리 교환
            players[cur - 1] = name;
            players[cur] = front;

            // 맵 갱신
            rank.put(name, cur - 1);
            rank.put(front, cur);
        }
        return players;
    }
}