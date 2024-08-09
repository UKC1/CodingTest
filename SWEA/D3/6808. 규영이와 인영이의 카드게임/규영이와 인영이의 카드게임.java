import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

            int[] result = new int[2]; // [0]: 규영 승리 횟수, [1]: 인영 승리 횟수
            dfs(9, new boolean[9], iny, new int[9], 0, kyu, result);

            System.out.println("#" + test_case + " " + result[0] + " " + result[1]);
        }
    }

    static void dfs(int N, boolean[] visited, int[] iny, int[] arr, int idx, int[] kyu, int[] result) {
        if (idx == N) {
            int kyuScore = 0;
            int inyScore = 0;

            for (int i = 0; i < N; i++) {
                if (kyu[i] > arr[i]) {
                    kyuScore += kyu[i] + arr[i];
                } else if (kyu[i] < arr[i]) {
                    inyScore += kyu[i] + arr[i];
                }
            }

            if (kyuScore > inyScore) {
                result[0]++;
            } else if (inyScore > kyuScore) {
                result[1]++;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = iny[i];
                dfs(N, visited, iny, arr, idx + 1, kyu, result);
                visited[i] = false;
            }
        }
    }
}