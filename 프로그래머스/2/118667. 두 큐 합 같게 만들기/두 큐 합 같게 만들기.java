import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        // 두 큐의 합 체크
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        // 두 큐의 합이 짝수여야 절반으로 나눠서 같아짐 홀수면 컷!
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        while (sum1 != sum2) {
            if (sum1 > sum2) {
                int qq1 = q1.poll();
                q2.add(qq1);

                sum1 -= qq1;
                sum2 += qq1;
                answer++;

            } else {
                int qq2 = q2.poll();
                q1.add(qq2);

                sum1 += qq2;
                sum2 -= qq2;
                answer++;
            }

            if (answer > q1.size() + q2.size() + 2) {
                answer = -1;
                break;
            }

            if (q1.isEmpty() || q2.isEmpty()) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}