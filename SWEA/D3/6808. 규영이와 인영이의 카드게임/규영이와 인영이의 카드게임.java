import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            boolean[] cards = new boolean[19];
            int[] kyu = new int[9];
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                cards[num] = true;
                kyu[i] = num;
            }

            int[] iny = new int[9];
            int idx = 0;
            for (int i = 1; i < cards.length; i++) {
                if (!cards[i]) {
                    iny[idx++] = i;
                }
            }

            List<int[]> list = new ArrayList<>();
            dfs(9, 9, new boolean[9], iny, new int[9], 0, list);
            int totalKyuWin = 0;
            for (int[] inyes : list ) {
                int inyScore = 0;
                int kyuScore = 0;
                for (int i = 0; i < kyu.length; i++) {
                    if (kyu[i] > inyes[i]) {
                        kyuScore += kyu[i] + inyes[i];
                    } else if (kyu[i] < inyes[i]) {
                        inyScore += kyu[i] + inyes[i];
                    }
                }
                if (kyuScore > inyScore) {
                    totalKyuWin++;
                }
            }
            System.out.println("#" + test_case + " " + totalKyuWin + " " + (list.size() - totalKyuWin));
        }
    }

    static void dfs(int N, int M, boolean[] visited,int[] iny, int[] arr, int idx, List<int[]> list) {
        if (idx == M) {
            int[] newArr = new int[M];
            System.arraycopy(arr, 0, newArr, 0, M);
            list.add(newArr);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = iny[i];
                dfs(N, M, visited, iny, arr, idx + 1, list);
                visited[i] = false;
            }
        }
    }
}