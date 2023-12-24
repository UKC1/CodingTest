import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = IntStream.of(arr).filter(n -> n != min).toArray();
        return answer.length == 0 ? new int[] {-1} : answer;
    }
}