import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        boolean[][] visited = new boolean[n][n];

        // 빈 공간과 퍼즐 조각 찾기
        List<int[][]> spaces = extractPieces(game_board, 0, visited); // 게임 보드에서 빈 공간 추출
        visited = new boolean[n][n]; // 방문 배열 초기화
        List<int[][]> pieces = extractPieces(table, 1, visited); // 테이블에서 퍼즐 조각 추출

        // 모든 퍼즐 조각에 대해 모든 회전 상태 생성
        List<List<int[][]>> rotatedPieces = new ArrayList<>();
        for (int[][] piece : pieces) {
            rotatedPieces.add(generateRotations(piece));
        }

        int answer = 0;
        // 빈 공간에 퍼즐 조각 맞추기
        boolean[] used = new boolean[rotatedPieces.size()];
        for (int[][] space : spaces) {
            for (int i = 0; i < rotatedPieces.size(); i++) {
                if (used[i]) continue;
                List<int[][]> rotations = rotatedPieces.get(i);
                if (fitPiece(space, rotations)) {
                    used[i] = true;
                    answer += countCells(rotations.get(0)); // 회전 상태는 동일 크기이므로 어느 하나를 사용
                    break;
                }
            }
        }

        return answer;
    }

    private List<int[][]> extractPieces(int[][] board, int type, boolean[][] visited) {
        List<int[][]> pieces = new ArrayList<>();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == type) {
                    List<int[]> part = new ArrayList<>();
                    dfs(board, i, j, visited, part, type);
                    pieces.add(convertToArray(part));
                }
            }
        }
        return pieces;
    }

    private void dfs(int[][] board, int x, int y, boolean[][] visited, List<int[]> part, int type) {
        if (x < 0 || x >= board.length || y < 0 || y >= board.length || visited[x][y] || board[x][y] != type)
            return;
        visited[x][y] = true;
        part.add(new int[]{x, y});
        for (int d = 0; d < 4; d++) {
            dfs(board, x + dx[d], y + dy[d], visited, part, type);
        }
    }

    private int[][] convertToArray(List<int[]> part) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : part) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] p : part) {
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
        }
        int[][] array = new int[maxX - minX + 1][maxY - minY + 1];
        for (int[] p : part) {
            array[p[0] - minX][p[1] - minY] = 1;
        }
        return array;
    }

    private List<int[][]> generateRotations(int[][] piece) {
        List<int[][]> rotations = new ArrayList<>();
        rotations.add(piece);
        for (int i = 0; i < 3; i++) {
            piece = rotate90(piece);
            rotations.add(piece);
        }
        return rotations;
    }

    private int[][] rotate90(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] newMatrix = new int[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                newMatrix[c][rows - 1 - r] = matrix[r][c];
            }
        }
        return newMatrix;
    }

    private boolean fitPiece(int[][] space, List<int[][]> rotations) {
        for (int[][] rot : rotations) {
            if (Arrays.deepEquals(space, rot)) {
                return true;
            }
        }
        return false;
    }

    private int countCells(int[][] piece) {
        int count = 0;
        for (int[] row : piece) {
            for (int cell : row) {
                if (cell == 1) count++;
            }
        }
        return count;
    }
}
