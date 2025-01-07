import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] lands = new int[N][N]; // 겨울 양분 추가량
        int[][] nutritions = new int[N][N]; // 현재 양분
        List<Integer>[][] trees = new ArrayList[N][N]; // 각 칸의 나무 리스트

        // 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lands[i][j] = Integer.parseInt(st.nextToken());
                nutritions[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        // 나무 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(age);
        }

        // K년 동안 시뮬레이션 진행
        for (int year = 0; year < K; year++) {
            // 봄 & 여름
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (trees[x][y].isEmpty()) continue;

                    List<Integer> newTrees = new ArrayList<>();
                    int deadNutrients = 0;

                    // 나무 나이순으로 정렬 후 양분 소비
                    trees[x][y].sort(Comparator.naturalOrder());
                    for (int age : trees[x][y]) {
                        if (nutritions[x][y] >= age) {
                            nutritions[x][y] -= age;
                            newTrees.add(age + 1);
                        } else {
                            deadNutrients += age / 2; // 여름
                        }
                    }

                    // 업데이트
                    trees[x][y] = newTrees;
                    nutritions[x][y] += deadNutrients;
                }
            }

            // 가을
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    for (int age : trees[x][y]) {
                        if (age % 5 == 0) { // 나이가 5의 배수인 경우 번식
                            for (int dir = 0; dir < 8; dir++) {
                                int nx = x + dx[dir];
                                int ny = y + dy[dir];
                                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                                trees[nx][ny].add(1);
                            }
                        }
                    }
                }
            }

            // 겨울
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    nutritions[x][y] += lands[x][y];
                }
            }
        }

        // 살아남은 나무 수 계산
        int survivalTrees = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                survivalTrees += trees[x][y].size();
            }
        }

        System.out.println(survivalTrees);
    }
}