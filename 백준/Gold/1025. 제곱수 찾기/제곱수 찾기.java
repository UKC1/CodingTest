import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static char[][] grid;
    static int maxSquare = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // 모든 시작점 (x, y)에서 모든 dx, dy를 탐색
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                for (int dx = -N; dx < N; dx++) {
                    for (int dy = -M; dy < M; dy++) {
                        if (dx == 0 && dy == 0) continue; // 변화가 없으면 스킵
                        searchMaxSquare(x, y, dx, dy);
                    }
                }
            }
        }
        System.out.println(maxSquare);
    }

    // 특정 방향 (dx, dy)로 이동하며 최대 제곱수를 찾는 함수
    static void searchMaxSquare(int x, int y, int dx, int dy) {
        int num = 0;
        int nx = x, ny = y;

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            num = num * 10 + (grid[nx][ny] - '0'); // 숫자 만들기
            if (isPerfectSquare(num)) {
                maxSquare = Math.max(maxSquare, num);
            }
            nx += dx;
            ny += dy;
        }
    }

    // 주어진 숫자가 제곱수인지 판별하는 함수
    static boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
