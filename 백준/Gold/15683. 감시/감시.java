import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int M;
    static List<int[]> cctvPoints;
    static List<Integer> cctvNums;
    static int minEdgeSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctvPoints = new ArrayList<>();
        cctvNums = new ArrayList<>();
        minEdgeSize = N * M;
        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] != 0 && maps[i][j] != 6) {
                    cctvPoints.add(new int[]{i, j});
                    cctvNums.add(maps[i][j]);
                }
            }
        }
        /*
        1 => 상 하 좌 우 4번
        2 => 상하 좌우 2번
        3 => 3번 상우 4번
        4 => 좌 상 우 4번
        5 => 상 화 좌 우 1번
        6 => 벽

        사각지대 최소 크기 구하라

        직관적 접근
        1. CCTV 방향에 따라서 맵 초기화
            1번 => 4가지
            2번 => 2가지
            3번 => 4가지
            4번 => 4가지
            5번 => 1가지
         다 끝나면 -1 개수 찾기
         */
        dfs(0, maps);
        System.out.print(minEdgeSize);
    }

    static void dfs(int idx, int[][] maps) {
        if (idx == cctvPoints.size()) {
            int edgeSize = calculateSize(maps);
            minEdgeSize = Math.min(edgeSize, minEdgeSize);
            return;
        }

        int cctvID = cctvNums.get(idx);
        int x = cctvPoints.get(idx)[0];
        int y = cctvPoints.get(idx)[1];

        if (cctvID == 1) {
            // 상
            int[][] upMaps = mapCopy(maps);
            upDirect(upMaps, x, y);
            dfs(idx + 1, upMaps);
            // 하
            int[][] downMaps = mapCopy(maps);
            downDirect(downMaps, x, y);
            dfs(idx + 1, downMaps);
            // 좌
            int[][] leftMaps = mapCopy(maps);
            leftDirect(leftMaps, x, y);
            dfs(idx + 1, leftMaps);
            // 우
            int[][] rightMaps = mapCopy(maps);
            rightDirect(rightMaps, x, y);
            dfs(idx + 1, rightMaps);
        } else if (cctvID == 2) {
            // 상 하
            int[][] upDownMaps = mapCopy(maps);
            upDirect(upDownMaps, x, y);
            downDirect(upDownMaps, x, y);
            dfs(idx + 1, upDownMaps);
            // 좌 우
            int[][] leftRightMaps = mapCopy(maps);
            leftDirect(leftRightMaps, x, y);
            rightDirect(leftRightMaps, x, y);
            dfs(idx + 1, leftRightMaps);
        } else if (cctvID == 3) {
            // 상 우
            int[][] upRightMaps = mapCopy(maps);
            upDirect(upRightMaps, x, y);
            rightDirect(upRightMaps, x, y);
            dfs(idx + 1, upRightMaps);

            // 우 하
            int[][] rightDownMaps = mapCopy(maps);
            rightDirect(rightDownMaps, x, y);
            downDirect(rightDownMaps, x, y);
            dfs(idx + 1, rightDownMaps);

            // 하 좌
            int[][] downLeftMaps = mapCopy(maps);
            downDirect(downLeftMaps, x, y);
            leftDirect(downLeftMaps, x, y);
            dfs(idx + 1, downLeftMaps);

            // 좌 상
            int[][] leftUpMaps = mapCopy(maps);
            leftDirect(leftUpMaps, x, y);
            upDirect(leftUpMaps, x, y);
            dfs(idx + 1, leftUpMaps);

        } else if (cctvID == 4) {
            // 좌 상 우
            int[][] leftUpRightMaps = mapCopy(maps);
            leftDirect(leftUpRightMaps, x, y);
            upDirect(leftUpRightMaps, x, y);
            rightDirect(leftUpRightMaps, x, y);
            dfs(idx + 1, leftUpRightMaps);
            // 상 우 하
            int[][] upRightDownMaps = mapCopy(maps);
            upDirect(upRightDownMaps, x, y);
            rightDirect(upRightDownMaps, x, y);
            downDirect(upRightDownMaps, x, y);
            dfs(idx + 1, upRightDownMaps);
            // 우 하 좌
            int[][] rightDownLeftMaps = mapCopy(maps);
            rightDirect(rightDownLeftMaps, x, y);
            downDirect(rightDownLeftMaps, x, y);
            leftDirect(rightDownLeftMaps, x, y);
            dfs(idx + 1, rightDownLeftMaps);

            // 하 좌 상
            int[][] downLeftUpMaps = mapCopy(maps);
            downDirect(downLeftUpMaps, x, y);
            leftDirect(downLeftUpMaps, x, y);
            upDirect(downLeftUpMaps, x, y);
            dfs(idx + 1, downLeftUpMaps);
        } else if (cctvID == 5) {
            // 상 하 좌 우
            int[][] upDownLeftRightMaps = mapCopy(maps);
            upDirect(upDownLeftRightMaps, x, y);
            downDirect(upDownLeftRightMaps, x, y);
            rightDirect(upDownLeftRightMaps, x, y);
            leftDirect(upDownLeftRightMaps, x, y);
            dfs(idx + 1, upDownLeftRightMaps);
        }
    }

    private static void rightDirect(int[][] rightMaps, int x, int y) {
        for (int ny = y + 1; ny < M; ny++) {
            if (rightMaps[x][ny] == 0) {
                rightMaps[x][ny] = -1;
            } else if (rightMaps[x][ny] == 6) {
                break;
            }
        }
    }

    private static void leftDirect(int[][] leftMaps, int x, int y) {
        for (int ny = y - 1; ny >= 0; ny--) {
            if (leftMaps[x][ny] == 0) {
                leftMaps[x][ny] = -1;
            } else if (leftMaps[x][ny] == 6) {
                break;
            }
        }
    }

    private static void downDirect(int[][] downMaps, int x, int y) {
        for (int nx = x + 1; nx < N; nx++) {
            if (downMaps[nx][y] == 0) {
                downMaps[nx][y] = -1;
            } else if (downMaps[nx][y] == 6) {
                break;
            }
        }
    }

    private static void upDirect(int[][] upMaps, int x, int y) {
        for (int nx = x - 1; nx >= 0; nx--) {
            if (upMaps[nx][y] == 0) {
                upMaps[nx][y] = -1;
            } else if (upMaps[nx][y] == 6) {
                break;
            }
        }
    }

    static int calculateSize(int[][] maps) {
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) {
                    size++;
                }
            }
        }
        return size;
    }
    static int[][] mapCopy(int[][] maps) {
        int[][] copyMaps = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(maps[i], 0, copyMaps[i], 0, M);
        }
        return copyMaps;
    }
}