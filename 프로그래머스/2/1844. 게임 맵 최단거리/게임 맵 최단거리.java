import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int x = maps.length, y = maps[0].length;
        boolean[][] visited = new boolean[x][y];
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.currentX + 1 == x && node.currentY + 1 == y) {
                return node.count;   
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            for (int i = 0; i < 4; i++) {
                int nx = node.currentX + dx[i];
                int ny = node.currentY + dy[i];
                
                if (nx >= 0 && ny >= 0 
                    && nx < x && ny < y
                   && !visited[nx][ny]
                   && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, node.count + 1));
                }
            }
        }
        return -1;
    }
}

class Node {
    int currentX;
    int currentY;
    int count;
    
    public Node(int currentX, int currentY, int count) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.count = count; 
    }
}