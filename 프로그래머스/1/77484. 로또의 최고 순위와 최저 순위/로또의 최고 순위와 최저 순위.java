import java.util.HashSet;
import java.util.HashMap;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        
        HashSet<Integer> set = new HashSet();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < win_nums.length; i++) {
            set.add(win_nums[i]);
            map.put(i + 1, 6 - i);
        }
        
        int zero = 0;
        int win = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero ++;
            } else {
                set.add(lottos[i]);
            }
        }
        
        win = 6 - set.size() + 6 - zero;
        answer[0] = win + zero >= 2 ? map.get(win + zero) : 6;
        answer[1] = win > 1 ? map.get(win) : 6;
        return answer;
    }
}