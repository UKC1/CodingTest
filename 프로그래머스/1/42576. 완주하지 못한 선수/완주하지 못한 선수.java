import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap();
        
        for (int i = 0; i < completion.length; i++) {
            if (map.get(completion[i]) == null) {
                map.put(completion[i], 1);
            } else {
                map.put(completion[i], map.get(completion[i]) + 1);
            }
        }
        
        for (int i = 0; i < participant.length; i++) {
            if (map.get(participant[i]) == null) {
                answer = participant[i];
                break;
            }  
            map.put(participant[i], map.get(participant[i]) - 1);
            if (map.get(participant[i]) < 0) {
                answer = participant[i];
                break;
            } 
        }
        return answer;
    }
}