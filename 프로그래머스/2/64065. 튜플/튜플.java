import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        return Arrays.stream(s.substring(2, s.length() - 2).split("},\\{"))
                     .map(str -> str.split(","))
                     .sorted(Comparator.comparingInt(a -> a.length))
                     .flatMap(Arrays::stream)
                     .mapToInt(Integer::parseInt)
                     .distinct()
                     .toArray();
    }
}
