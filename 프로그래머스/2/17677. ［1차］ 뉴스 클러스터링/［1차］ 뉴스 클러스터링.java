import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
      
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp1 = str1.substring(i, i + 2);
            if (tmp1.matches("[a-z]{2}")) {
                list1.add(tmp1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp2 = str2.substring(i, i + 2);
            if (tmp2.matches("[a-z]{2}")) {
                list2.add(tmp2);
            }
        }

        int intersect = 0;
        for (String s : new ArrayList<>(list1)) {
            if (list2.remove(s)) {
                intersect++;
            }
        }

        int union = list1.size() + list2.size();
        
        double answer;
        if (union == 0) {
            answer = 1; 
        } else {
            answer = (double) intersect / union;
        }

        return (int) (answer * 65536);
    }
}
