import java.util.*;
class Solution {
    int answer = 0;
    int n;
    int r;
    Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        // 조합으로 가보자
        n = user_id.length;
        r = banned_id.length;
        permutation(banned_id, user_id, new String[r], new boolean[n], 0);
        return answer;
    }
    
    void permutation(String[] banned_id, String[] user_id, String[] tmp, boolean[] visited, int idx) {
        if (idx == r) {
            String[] str = Arrays.copyOf(tmp, r);
            Arrays.sort(str);
            StringBuilder sb = new StringBuilder();
            for (String t : str) {
                sb.append(t);
            }
            String element = sb.toString();
            if (!set.contains(element) && isBanned(tmp, banned_id)) {
                set.add(element);
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                tmp[idx] = user_id[i]; 
                visited[i] = true;
                permutation(banned_id, user_id, tmp, visited, idx + 1);
                visited[i] = false;
            }
        }
    }
    
    boolean isBanned(String[] tmp, String[] banned_id) {
        for (int i = 0; i < r; i++) {
            if (banned_id[i].length() != tmp[i].length() 
                || !isPassed(tmp[i], banned_id[i])) return false;           
        }
        return true;
    }
    
    boolean isPassed(String id, String ban) {
        for (int i = 0; i < id.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != id.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}