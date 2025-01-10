import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // players 현재 등수 순서
        // callings 한 번 부를 때 마다 등수가 1번 증가함
        Map<String, Integer> nameAndRate = new HashMap<>();
        Map<Integer, String> rateAndName = new LinkedHashMap<>();
        for (int i = 0; i < players.length; i++) {
            nameAndRate.put(players[i], i + 1);
            rateAndName.put(i + 1, players[i]);
        }
        
        for (String call : callings) {
            int rate = nameAndRate.get(call);
            String name = rateAndName.get(rate - 1);
            rateAndName.put(rate - 1, call);
            rateAndName.put(rate, name);
            nameAndRate.put(name, rate);
            nameAndRate.put(call, rate - 1);
        }
        String[] answer = new String[players.length];
        int idx = 0;
        for (Integer num : rateAndName.keySet()) {
            answer[idx++] = rateAndName.get(num); 
        }
        
        return answer;
    }
}