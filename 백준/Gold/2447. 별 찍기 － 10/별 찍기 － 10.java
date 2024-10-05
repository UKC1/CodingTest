import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] stars = new char[N][N];

        // 배열을 공백으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stars[i][j] = ' ';
            }
        }

        // 재귀적으로 별 찍기
        star(N, stars, 0, 0);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void star(int N, char[][] stars, int x, int y) {
        if (N == 1) {
            stars[x][y] = '*';
            return;
        }

        int size = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // 가운데 부분은 비워야 함
                    continue;
                }
                // 재귀적으로 9개 부분을 채워 나감
                star(size, stars, x + i * size, y + j * size);
            }
        }
    }
}