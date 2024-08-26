import java.util.*;
class Solution {
    boolean found = false;
    List<String> pass = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        pass.add("ICN");
        Arrays.sort(tickets, (s1, s2) -> (s1[1].compareTo(s2[1])));
        dfs("ICN", new boolean[tickets.length], tickets, 0);
        return pass.toArray(new String[0]);
    }
    
    void dfs(String start, boolean[] visited, String[][] tickets, int cnt) {
        if (cnt == visited.length) {
            found = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                pass.add(tickets[i][1]);
                dfs(tickets[i][1], visited, tickets, cnt + 1);
                if (found) return;
                visited[i] = false;
                pass.remove(pass.size() - 1);
            }
        }
    }
}