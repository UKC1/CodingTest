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
    static List<int[]> chickenDistList;
    static List<int[]> homes;
    static int minChickenDist;
    static int minSumChickenDist;
    static int N;
    static int M;
    static int[][] chickens;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenDistList = new ArrayList<>();
        homes = new ArrayList<>();
        minSumChickenDist = Integer.MAX_VALUE;
        chickens = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chickens[i][j] = Integer.parseInt(st.nextToken());
                if (chickens[i][j] == 2) {
                    chickenDistList.add(new int[]{i, j});
                } else if (chickens[i][j] == 1) {
                    homes.add(new int[]{i, j});
                }
            }
        }

        // 0은 빈 칸
        // 1은 집
        // 2는 치킨집
        // 1 2 1 1
        // 치킨 거리 : 가장 가까운 치킨집 사이의 거리
        // 도시의 치킨 거리 : 모든 집의 치킨 거리의 합
        // 치킨집 정하기
        // 각각 치킨 거리 합 최소값
        comb(new int[M], 0, 0);
        System.out.print(minSumChickenDist);
    }

    static void comb(int[] arr, int idx, int start) {
        if (idx == M) {
            int sum = 0;
            // 치킨집 고정
            for (int i = 0; i < homes.size(); i++) {
                minChickenDist = Integer.MAX_VALUE;
                int x = homes.get(i)[0];
                int y = homes.get(i)[1];
                for (int j = 0; j < arr.length; j++) {
                    int num = arr[j];
                    int cx = chickenDistList.get(num)[0];
                    int cy = chickenDistList.get(num)[1];
                    int dist = Math.abs(x - cx) + Math.abs(y - cy);
                    minChickenDist = Math.min(minChickenDist, dist);
                }
//                System.out.println(minChickenDist);
                sum += minChickenDist;
            }
//            System.out.println(sum);
            minSumChickenDist = Math.min(minSumChickenDist, sum);
            return;
        }

        for (int i = start; i < chickenDistList.size(); i++) {
            arr[idx] = i;
            comb(arr, idx + 1, i + 1);
        }
    }
}