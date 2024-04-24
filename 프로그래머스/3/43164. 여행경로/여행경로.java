import java.util.*;

class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> allPaths = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1])); // Sort tickets to prioritize lexicographical order

        // Start DFS from 'ICN'
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                path.add("ICN"); // Start from ICN
                dfs(tickets, visited, i);
                path.remove(path.size() - 1);
            }
        }

        // Sort all found paths lexicographically
        Collections.sort(allPaths, (a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int comp = a.get(i).compareTo(b.get(i));
                if (comp != 0) return comp;
            }
            return 0;
        });

        return allPaths.isEmpty() ? new String[0] : allPaths.get(0).toArray(new String[0]);
    }

    public void dfs(String[][] tickets, boolean[] visited, int index) {
        visited[index] = true;
        path.add(tickets[index][1]);

        if (path.size() == tickets.length + 1) {
            allPaths.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(tickets[index][1])) {
                    dfs(tickets, visited, i);
                }
            }
        }

        visited[index] = false;
        path.remove(path.size() - 1);
    }
}
