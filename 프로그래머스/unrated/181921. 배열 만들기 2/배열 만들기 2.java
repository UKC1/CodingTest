import java.util.ArrayList;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = l; i <= r; i++) {
            int j = i;
            boolean ch = true;
            while(j > 0) {
                if (j % 5 == 0) {
                    j /= 10;
                } else {
                    ch = false;
                    break;
                }
            }
            if (ch) {
                list.add(i);
            }
            
        }
        
        int[] answer = new int[list.size()];
        if (list.size() == 0) {
            return new int[] {-1};
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}