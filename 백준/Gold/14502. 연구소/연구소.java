import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] maps;
    static int[][] copyMap;
    static List<Point> blankList;
    static List<Point> virusList;
    static int maxSafeZone;
    static int virusCnt;

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        blankList = new ArrayList<>();
        virusList = new ArrayList<>();
        maxSafeZone = 0;
        virusCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 0) {
                    blankList.add(new Point(i, j));
                } else if (maps[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        combination(0, 0);
        System.out.print(maxSafeZone);

    }
    static void combination(int index, int start) {
        if (index == 3) {
            mapCopy();
            virusCnt = 0;
            for (Point virus : virusList) {
                spreadVirus(virus.x, virus.y);
            }

            int safeCnt = blankList.size() - virusCnt - 3;
            if (safeCnt > maxSafeZone) maxSafeZone = safeCnt;
            return;
        }
        for (int i = start; i < blankList.size(); i++) {
            maps[blankList.get(i).x][blankList.get(i).y] = 1;
            combination(index + 1, i + 1);
            maps[blankList.get(i).x][blankList.get(i).y] = 0;
        }

    }
    static void mapCopy() {
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(maps[i], 0, copyMap[i], 0, M);
        }
    }
    static void spreadVirus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && copyMap[nx][ny] == 0) {
                copyMap[nx][ny] = 2;
                virusCnt++;
                spreadVirus(nx, ny);
            }
        }
    }
}