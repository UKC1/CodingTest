import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] numStrs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }

        // 문자열 배열을 정렬
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);  // 내림차순 정렬
            }
        });

        // 정렬된 문자열 배열을 결합하여 결과 생성
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }

        // 결과가 "0"으로 시작하는 경우 처리 (모든 숫자가 0인 경우)
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
