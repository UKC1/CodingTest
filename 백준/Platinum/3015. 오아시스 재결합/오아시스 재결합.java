import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Pair {
        int height, count;

        Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();
        long totalCnt = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1; // 현재 사람 포함

            while (!stack.isEmpty() && stack.peek().height <= height) {
                Pair top = stack.pop();
                totalCnt += top.count;

                // 같은 키면 추가
                if (top.height == height) {
                    count += top.count;
                }
            }

            if (!stack.isEmpty()) {
                totalCnt++;
            }

            stack.push(new Pair(height, count));
        }
        System.out.println(totalCnt);
    }
}
