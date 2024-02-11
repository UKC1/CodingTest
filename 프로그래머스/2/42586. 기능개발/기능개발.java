import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
         ArrayList<Integer> list = new ArrayList<>();

        // 앞의 원소가 완성되어야 다음 기능들도 넘길 수 있음
        // 1초 지날 때 마다 기능들 진행됨
        // 전부 다 완성될 때 까지 돌려야 함
        int sum = 0;
        int idx = 0;
        while (sum < progresses.length) {
            int cnt = 0;
            for (int i = idx; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            while (idx < progresses.length && progresses[idx] >= 100) {
                cnt++;
                idx++;
                sum++;
            }
            if (cnt != 0) {
                list.add(cnt);
            }
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}