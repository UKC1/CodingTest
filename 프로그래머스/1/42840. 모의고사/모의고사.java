import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] cntArr = new int[4];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5] ) cntArr[1]++;
            if (answers[i] == second[i % 8]) cntArr[2]++;
            if (answers[i] == third[i % 10]) cntArr[3]++;
        }
        
        int maxCnt = 0;
        for (int i = 1; i < cntArr.length; i++) {
            if (maxCnt < cntArr[i]) maxCnt = cntArr[i];
        }
        
        for (int i = 1; i < cntArr.length; i++) {
            if (maxCnt == cntArr[i]) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}