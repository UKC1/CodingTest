import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = populateKeyMap(keymap);

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            answer[i] = calculateKeyPresses(map, targets[i]);
        }

        return answer;
    }

    private HashMap<Character, Integer> populateKeyMap(String[] keymap) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < keymap.length; i++) {
        for (int j = 0; j < keymap[i].length(); j++) {
            char currentChar = keymap[i].charAt(j);
            int keyPresses = j + 1; // 키 입력 횟수 계산
            if (!map.containsKey(currentChar) || map.get(currentChar) > keyPresses) {
                map.put(currentChar, keyPresses); // 더 적은 키 입력 횟수로 업데이트
            }
        }
    }
    return map;
}

    private int calculateKeyPresses(HashMap<Character, Integer> map, String target) {
        int totalKeyPresses = 0;
        for (char ch : target.toCharArray()) {
            Integer keyPresses = map.get(ch);
            if (keyPresses == null) {
                return -1;
            }
            totalKeyPresses += keyPresses;
        }
        return totalKeyPresses;
    }
}
