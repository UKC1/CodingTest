import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> path = new ArrayList();
        boolean[] visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        path.add("ICN");
        dfs("ICN", tickets, visited, path, 0);
        return path.toArray(new String[0]);
    }
    public boolean dfs(String current, String[][] tickets, boolean[] visited, List<String> path, int cnt) {
        if (cnt == tickets.length) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && current.equals(tickets[i][0])) {
                path.add(tickets[i][1]);
                visited[i] = true;
                if (dfs(tickets[i][1], tickets, visited, path, cnt + 1)) {
                    return true;
                }
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        
        return false;
    }
}