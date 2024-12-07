import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] heights;
    static boolean isFind;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(heights);
        isFind = false;
        dfs(new int[7], 0, 0);
    }

    static void dfs(int[] seven, int idx, int start) {
        if (idx == 7) {
            int sum = Arrays.stream(seven).sum();
            if (sum == 100 && !isFind) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(seven[i]);
                }
                isFind = true;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            seven[idx] = heights[i];
            dfs(seven, idx + 1, i + 1);
        }
    }
}