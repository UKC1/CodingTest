import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 여러 테스트 케이스를 처리 (0이 입력되면 종료)
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break; // 종료 조건

            int[] histogram = new int[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            long maxArea = getMaxArea(histogram);
            sb.append(maxArea).append("\n");
        }
        System.out.print(sb);
    }

    // 스택을 이용하여 히스토그램에서 가장 큰 직사각형 면적을 구하는 메서드
    public static long getMaxArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long max = 0;

        // 인덱스 0부터 n까지 순회합니다.
        // i == n일 경우 현재 막대의 높이를 0으로 처리하여 남은 스택에 대해 면적 계산을 수행합니다.
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : arr[i];

            // 스택이 비어있지 않고 현재 막대의 높이가 스택의 top에 있는 막대보다 작을 때
            while (!stack.isEmpty() && currentHeight < arr[stack.peek()]) {
                int topIndex = stack.pop();
                long height = arr[topIndex];
                int width;

                if (stack.isEmpty()) {
                    // 스택이 비었다면 왼쪽 경계는 0
                    width = i;
                } else {
                    // 현재 인덱이 right boundary, 스택 top의 인덱스가 left boundary가 됩니다.
                    width = i - stack.peek() - 1;
                }
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        return max;
    }
}