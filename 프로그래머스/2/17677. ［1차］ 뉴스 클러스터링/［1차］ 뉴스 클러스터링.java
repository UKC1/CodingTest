import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        String patternString = "^[a-z]+$";
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp1 = str1.toLowerCase().substring(i, i + 2);
            if (tmp1.matches(patternString)) {
                list1.add(tmp1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp2 = str2.toLowerCase().substring(i, i + 2);
            if (tmp2.matches(patternString)) {
                list2.add(tmp2);
            }
        }
        
        double answer = list2.size();
        for (String s : list1) {
            list2.remove(s);
        }
        
        double intersect = answer - list2.size();
        double uniform = list2.size() + list1.size();
        
        answer = intersect / uniform;
        // System.out.println(list1);
        // System.out.println(list2);
        // System.out.println(intersect);
        // System.out.println(uniform);
        if (uniform == 0) {
            return 65536;
        }
        return (int) (answer * 65536);
    }
}