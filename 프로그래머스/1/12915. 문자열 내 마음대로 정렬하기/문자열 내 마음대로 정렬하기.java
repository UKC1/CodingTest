import java.util.ArrayList;
import java.util.Collections;

class Pair {
    String originalString;
    char nthChar;

    public Pair(String originalString, int n) {
        this.originalString = originalString;
        this.nthChar = originalString.charAt(n);
    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<Pair> pairs = new ArrayList<>();

        // Pair 객체를 생성하여 ArrayList에 추가
        for (String s : strings) {
            pairs.add(new Pair(s, n));
        }

        // 사용자 정의 정렬 로직 적용
        Collections.sort(pairs, (p1, p2) -> {
            if (p1.nthChar == p2.nthChar) {
                return p1.originalString.compareTo(p2.originalString);
            }
            return p1.nthChar - p2.nthChar;
        });

        // 정렬된 문자열을 결과 배열에 저장
        String[] answer = new String[strings.length];
        for (int i = 0; i < pairs.size(); i++) {
            answer[i] = pairs.get(i).originalString;
        }
        return answer;
    }
}
