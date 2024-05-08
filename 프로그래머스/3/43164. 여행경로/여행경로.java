import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 항공권을 출발 도시 기준으로 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        List<String> answer = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        answer.add("ICN");  // 초기 출발 도시 추가

        dfs("ICN", tickets, visited, answer, 0);
        return answer.toArray(new String[0]);
    }

    private boolean dfs(String current, String[][] tickets, boolean[] visited, List<String> path, int count) {
        if (count == tickets.length) {
            return true; // 모든 티켓을 사용했으면 true 반환
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, visited, path, count + 1)) {
                    return true; // 경로 완성
                }
                
                visited[i] = false; // 백트래킹
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}
