import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 우 하 좌 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, K, L;
    static int[][] maps;
    static Map<Integer, Character> dirMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        // 사과의 위치
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            maps[row][col] = 1;
        }
        L = Integer.parseInt(br.readLine());
        // 뱀의 방향 변환 정보
        // X초 끝난 뒤에 회전함
        dirMap = new HashMap<Integer, Character>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            dirMap.put(X, C);
        }

        int currentDir = 0;
        // 시작 0, 0 길이는 1

        int time = 0;
        int tailX = 0;
        int tailY = 0;
        int headX = 0;
        int headY = 0;
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{headX, headY});
        maps[tailX][tailY] = 2;
        while (true) {
            time++;
            int nx = headX + dx[currentDir];
            int ny = headY + dy[currentDir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || maps[nx][ny] == 2) {
                break;
            }

            // 사과를 먹으면 길이가 늘어남
            if (maps[nx][ny] == 1) {
                maps[nx][ny] = 2;
                headX = nx;
                headY = ny;
                snake.add(new int[]{headX, headY});
            } else {
                // 사과가 아니면 이동 꼬리도 이동
                maps[nx][ny] = 2;
                headX = nx;
                headY = ny;
                maps[tailX][tailY] = 0;
                snake.remove(0);
                snake.add(new int[]{headX, headY});
                tailX = snake.get(0)[0];
                tailY = snake.get(0)[1];
            }
            if (dirMap.containsKey(time)) {
                if (dirMap.get(time) == 'D') {
                    // 오른쪽 회전
                    currentDir = (currentDir + 1) % 4;
                } else {
                    // 왼쪽 회전
                    currentDir = (currentDir + 3) % 4;
                }
            }
        }
        System.out.print(time);
    }
}
