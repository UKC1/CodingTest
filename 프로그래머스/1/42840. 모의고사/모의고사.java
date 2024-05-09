import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneCnt = 0;
        int twoCnt = 0;
        int threeCnt = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                oneCnt++;
            } 
            
            if (answers[i] == two[i % two.length]) {
                twoCnt++;
            }
            
            if (answers[i] == three[i % three.length]) {
                threeCnt++;
            }
        }
        
        if (oneCnt == twoCnt && twoCnt == threeCnt) {
            return new int[] {1, 2, 3};
        }
        
        if (oneCnt == twoCnt && oneCnt > threeCnt) {
            list.add(1);
            list.add(2);
        }
        
        if (twoCnt == threeCnt && twoCnt > oneCnt) {
            list.add(2);
            list.add(3);
        }
        
        if (oneCnt == threeCnt && threeCnt > twoCnt) {
            list.add(1);
            list.add(3);
        }
        
        if (oneCnt > twoCnt &&  oneCnt > threeCnt) {
            list.add(1);
        }
        
        if (twoCnt > oneCnt &&  twoCnt > threeCnt) {
            list.add(2);
        }
        
        if (threeCnt > twoCnt &&  threeCnt > oneCnt) {
            list.add(3);
        }    
            
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}