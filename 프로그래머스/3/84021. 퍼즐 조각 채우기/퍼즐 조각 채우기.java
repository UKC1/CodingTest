import java.util.*;
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        int n = game_board.length;
        boolean[][] visited = new boolean[n][n];
        List<int[][]> spaces = extractPieces(game_board, 0, visited);
        visited = new boolean[n][n];
        List<int[][]> pieces = extractPieces(table, 1, visited);
        
        List<List<int[][]>> rotations = new ArrayList();
        for (int[][] piece : pieces) {
            rotations.add(gerateRotation(piece));
        }
        
        boolean[] used = new boolean[rotations.size()];
        for (int[][] space : spaces) {
            for (int i = 0; i < rotations.size(); i++) {
                if (used[i]) continue;
                List<int[][]> rotation = rotations.get(i);
                if (fitPiece(space, rotation)) {
                    used[i] = true;
                    answer += counCells(rotation.get(0));
                    break;
                }
            }
        }
        return answer;
    }
    
    public List<int[][]> extractPieces(int[][] board, int type, boolean[][] visited) {
        List<int[][]> pieces = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!visited[i][j] && board[i][j] == type) {
                    List<int[]> path = new ArrayList();
                    dfs(board, i, j, type, visited, path);           
                    pieces.add(convertToArray(path));
                }
            }
        }
        return pieces;
    }
    
    public void dfs(int[][] board, int x, int y, int type, boolean[][] visited, List<int[]> path) {
        visited[x][y] = true;
        path.add(new int[]{x, y});
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board.length && !visited[nx][ny] && board[nx][ny] == type) {
                dfs(board, nx, ny, type, visited, path);
            }
        }
        
    }
    
    public List<int[][]> gerateRotation(int[][] piece) {
        List<int[][]> rotations = new ArrayList();
        rotations.add(piece);       
        for(int i = 0; i < 3; i++) {
            piece = rotate90(piece);
            rotations.add(piece);
        }
        return rotations;
    }
    
    public int[][] rotate90(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;  
        
        int[][] newMatrix = new int[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                newMatrix[c][rows - r - 1] = matrix[r][c];
            }
        }
        return newMatrix;
    }
    
    public int[][] convertToArray(List<int[]> part) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] pt : part) {
            minX = Math.min(minX, pt[0]);
            minY = Math.min(minY, pt[1]);
            maxX = Math.max(maxX, pt[0]);
            maxY = Math.max(maxY, pt[1]);
        }
        
        int[][] array = new int[maxX-minX+1][maxY-minY+1];
        for(int[] pt : part) {
            array[pt[0] - minX][pt[1] - minY] = 1;
        }
        
        return array;
    }
    
    public boolean fitPiece(int[][] space, List<int[][]> rotation) {
        for (int[][] rt : rotation) {
            if (Arrays.deepEquals(space, rt)) {
                return true;
            }   
        }
       
        return false;
    }
    
    public int counCells(int[][] rotate) {
        int count = 0;
        for (int[] rt : rotate) {
            for (int cell : rt) {
                if (cell == 1) count++;
            }
        }
        return count;
    }
}