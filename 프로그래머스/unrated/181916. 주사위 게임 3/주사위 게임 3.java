import java.util.TreeSet;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] arr = {a, b, c, d};
        TreeSet<Integer> set = new TreeSet();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        
        if (set.size() == 4) {
            answer = set.first();
            
        } else if (set.size() == 3) {
            answer = 1;
            for (Integer i : set) {
                int cnt = 0;
                answer *= i; 
                for (int j : arr) {
                    if (i == j) {
                        cnt++;
                    }
                }
                if (cnt > 1) {
                    answer /= i;
                }
            }
        } else if (set.size() == 2) {
            int minus = 0;
            boolean twoSet = false;
            for (Integer i : set) {
                int cnt = 0;
                for (int j : arr) {
                    if (i == j) {
                        cnt++;
                    }
                }
                if (cnt == 3) {
                    answer += 10 * i;
                } else if (cnt == 2) {
                    if (twoSet) {
                        answer += i;
                        minus -= i;
                        return answer * Math.abs(minus);
                    }
                    answer += i;
                    minus += i;
                    twoSet = true;
                } else {
                    answer += i;
                }
            }
            answer *= answer;
            
        } else if (set.size() == 1) {
            answer = 1111 * set.first();
        }
        return answer;
    }
}