import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if (map.get(keymap[i].charAt(j)) == null) {
                    map.put(keymap[i].charAt(j), j + 1);
                } else if (map.get(keymap[i].charAt(j)) > j + 1) {
                    map.put(keymap[i].charAt(j), j + 1);
                } 
            }
        }
        
        System.out.println(map);
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j< targets[i].length(); j++) {
                if (map.get(targets[i].charAt(j)) == null) {
                    answer[i] = 0;
                    break;
                }
                answer[i] += map.get(targets[i].charAt(j));
            }
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
                
        return answer;
    }
}