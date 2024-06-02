import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String s : str) {
            answer.append(s);
        }
        return answer.toString();
    }
}
