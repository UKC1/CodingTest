import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList();
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1])); 
        }
        
        String[] todayDate = today.split("\\.");
        int today_yyyy =  Integer.parseInt(todayDate[0]);
        int today_mm =  Integer.parseInt(todayDate[1]);
        int today_dd =  Integer.parseInt(todayDate[2]);
        
            
        for (int i = 0; i < privacies.length; i++) {
            String day = privacies[i].split(" ")[0];
            int gap = map.get(privacies[i].split(" ")[1]);
            
            String[] str = day.split("\\.");
            int yyyy = Integer.parseInt(str[0]);
            int mm = Integer.parseInt(str[1]) + gap;
            int dd = Integer.parseInt(str[2]) - 1;
            
            int expired_dd = dd == 0 ? 28 : dd;
            int expired_mm = mm == 12 ? 12 : mm % 12; 
            int expired_yyyy = mm == 12 ? yyyy : yyyy + mm / 12;
            
            if (expired_dd == 28) {
                expired_mm--;
            }
            if (expired_mm == 0) {
                expired_mm = 12;
                expired_yyyy--;
            }
           
            if (expired_yyyy < today_yyyy) {
                list.add(i + 1);
            } else if (expired_yyyy == today_yyyy) {
                if (expired_mm < today_mm) {
                    list.add(i + 1);
                } else if (expired_mm == today_mm) {
                    if (expired_dd < today_dd) {
                        list.add(i + 1);
                    }
                }
            }
            
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}