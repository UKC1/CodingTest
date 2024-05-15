import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) answer[0]++; 
            if (answers[i] == two[i % two.length]) answer[1]++; 
            if (answers[i] == three[i % three.length]) answer[2]++; 
        }
        
        List<Integer> list = Arrays.asList(answer[0], answer[1], answer[2]);
        List<Integer> score = new ArrayList();
        int max = Collections.max(list);
        
        for (int i = 0; i < list.size(); i++) {
            if (max == answer[i]) {
                score.add(i + 1);
            }
        }
        
        return score.stream().mapToInt(i -> i).toArray();
    }
}