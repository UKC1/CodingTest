import java.util.*;

class Solution {
    long max = 0;
    static final String[][] opOrders = {
        {"+", "-", "*"}, {"+", "*", "-"},
        {"-", "+", "*"}, {"-", "*", "+"},
        {"*", "+", "-"}, {"*", "-", "+"}
    };

    public long solution(String expression) {
        List<Long> nums = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        // 파싱
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                ops.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
        }
        nums.add(Long.parseLong(sb.toString())); // 마지막 숫자

        // 모든 우선순위 순열에 대해 계산
        for (String[] order : opOrders) {
            List<Long> tmpNums = new ArrayList<>(nums);
            List<String> tmpOps = new ArrayList<>(ops);

            for (String op : order) {
                for (int i = 0; i < tmpOps.size(); ) {
                    if (tmpOps.get(i).equals(op)) {
                        long a = tmpNums.get(i);
                        long b = tmpNums.get(i + 1);
                        long res = calc(a, b, op);
                        tmpNums.remove(i + 1);
                        tmpNums.set(i, res);
                        tmpOps.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            max = Math.max(max, Math.abs(tmpNums.get(0)));
        }

        return max;
    }

    long calc(long a, long b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
        }
        return 0;
    }
}
