import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class Main {
    static List<int[]> chickenDistList;
    static List<int[]> homes;
    static int minSumChickenDist;
    static int N, M;
    static int[][] distCache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickenDistList = new ArrayList<>();
        homes = new ArrayList<>();
        minSumChickenDist = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    chickenDistList.add(new int[]{i, j});
                } else if (value == 1) {
                    homes.add(new int[]{i, j});
                }
            }
        }

        // 거리 캐시 초기화
        int homeCount = homes.size();
        int chickenCount = chickenDistList.size();
        distCache = new int[homeCount][chickenCount];

        // 각 집과 치킨집 사이의 거리를 미리 계산하여 distCache에 저장
        for (int i = 0; i < homeCount; i++) {
            int hx = homes.get(i)[0];
            int hy = homes.get(i)[1];
            for (int j = 0; j < chickenCount; j++) {
                int cx = chickenDistList.get(j)[0];
                int cy = chickenDistList.get(j)[1];
                distCache[i][j] = Math.abs(hx - cx) + Math.abs(hy - cy);
            }
        }

        // 조합을 생성하여 최소 치킨 거리 계산
        comb(new int[M], 0, 0);
        System.out.print(minSumChickenDist);
    }

    // M개의 치킨집 조합을 선택하는 메서드
    static void comb(int[] selected, int idx, int start) {
        if (idx == M) {
            int totalDistance = 0;
            for (int i = 0; i < homes.size(); i++) {
                int minDist = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    minDist = Math.min(minDist, distCache[i][selected[j]]);
                }
                totalDistance += minDist;
                if (totalDistance >= minSumChickenDist) break; // 가지치기
            }
            minSumChickenDist = Math.min(minSumChickenDist, totalDistance);
            return;
        }

        for (int i = start; i < chickenDistList.size(); i++) {
            selected[idx] = i;
            comb(selected, idx + 1, i + 1);
        }
    }
}