import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int W;
    static int H;
    static int maxCnt;
    static int totalBricks;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            maxCnt = 0;
            totalBricks = 0;
            int[][] bricks = new int[H][W];
 
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    bricks[i][j] = Integer.parseInt(st.nextToken());
                    if (bricks[i][j] != 0) totalBricks++;
                }
            }
 
            // 각 열에 대해 탐색 시작
            for (int col = 0; col < W; col++) {
                int[][] brickCopy = copyArray(bricks);
                int startRow = findTopBrick(brickCopy, col);
                if (startRow == -1) continue;
                 
                dfs(brickCopy, startRow, col, 1, 0); // DFS 시작
            }
            sb.append('#').append(test_case).append(' ').append(totalBricks - maxCnt).append('\n');
        }
        System.out.print(sb);
    }
 
    static void dfs(int[][] brick, int x, int y, int depth, int sum) {
        int cnt = bombBrick(brick, x, y); // 현재 위치에서 벽돌 파괴 후 파괴된 개수 반환
        int currentSum = sum + cnt; // 현재까지의 누적된 파괴 수
 
        // 전체 벽돌을 파괴한 경우, 최대값 설정 후 종료
        if (currentSum >= totalBricks) {
            maxCnt = totalBricks;
            return;
        }
         
        // 탐색 깊이에 도달하면 최대값 갱신 후 종료
        if (depth == N) {
            maxCnt = Math.max(maxCnt, currentSum);
            return;
        }
 
        // 벽돌 재정렬
        setArr(brick);
 
        // 다음 단계 탐색
        for (int col = 0; col < W; col++) {
            int[][] nextBrick = copyArray(brick);
            int startRow = findTopBrick(nextBrick, col);
            if (startRow == -1) continue;
            dfs(nextBrick, startRow, col, depth + 1, currentSum); // sum 대신 currentSum을 넘김
        }
    }
 
    // 가장 위의 벽돌 위치 찾기
    static int findTopBrick(int[][] arr, int col) {
        for (int row = 0; row < H; row++) {
            if (arr[row][col] != 0) return row;
        }
        return -1;
    }
 
    static void setArr(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        for (int col = 0; col < W; col++) {
            for (int row = 0; row < H; row++) {
                if (arr[row][col] != 0) {
                    list.add(arr[row][col]);
                    arr[row][col] = 0;
                }
            }
 
            int idx = list.size() - 1;
            for (int row = H - 1; row >= 0 && idx >= 0; row--) {
                arr[row][col] = list.get(idx--);
            }
            list.clear();
        }
    }
 
    static int bombBrick(int[][] arr, int row, int col) {
        int len = arr[row][col];
        arr[row][col] = 0;
        int cnt = 1;
 
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                int nRow = row + dx[j] * i;
                int nCol = col + dy[j] * i;
 
                if (nRow >= 0 && nRow < H && nCol >= 0 && nCol < W && arr[nRow][nCol] != 0) {
                    cnt += bombBrick(arr, nRow, nCol);
                }
            }
        }
        return cnt;
    }
 
    static int[][] copyArray(int[][] arr) {
        int[][] newArr = new int[H][W];
        for (int i = 0; i < H; i++) {
            newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return newArr;
    }
}