import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i = 0 ; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) count[0]++;
            if (answers[i] == second[i % second.length]) count[1]++;
            if (answers[i] == third[i % third.length]) count[2]++;
            
        }
        int maxNum = 0;
        for (int i = 0; i < count.length; i++) {
            if (maxNum < count[i]) {
                maxNum = count[i];
            }
        }
        
        List<Integer> list = new ArrayList();
        for (int i = 0 ; i < count.length; i++) {
            if (maxNum == count[i]) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}