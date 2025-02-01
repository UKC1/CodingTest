import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue; // 빈 줄은 건너뜁니다.
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;  // 종료 조건

            histogram = new int[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            long maxArea = getMaxArea(0, n - 1);
            sb.append(maxArea).append("\n");
        }

        System.out.print(sb);
    }

    /**
     * 분할 정복을 이용하여 [left, right] 구간 내 히스토그램에서 가장 큰 직사각형 면적을 구합니다.
     *
     * @param left  구간의 왼쪽 인덱스
     * @param right 구간의 오른쪽 인덱스
     * @return 해당 구간에서의 최대 직사각형 면적
     */
    public static long getMaxArea(int left, int right) {
        // 구간에 하나의 막대만 있다면 그 막대의 높이가 면적이 됩니다.
        if (left == right) {
            return histogram[left];
        }

        int mid = (left + right) / 2;
        // 왼쪽 구간과 오른쪽 구간에 대한 최대 면적을 재귀적으로 구합니다.
        long leftArea = getMaxArea(left, mid);
        long rightArea = getMaxArea(mid + 1, right);
        long maxArea = Math.max(leftArea, rightArea);

        // 중앙을 포함하여 양쪽으로 확장하는 경우를 계산합니다.
        int l = mid;
        int r = mid + 1;
        long height = Math.min(histogram[l], histogram[r]);
        // 초기 영역은 두 개의 인접한 막대가 구성하는 영역
        maxArea = Math.max(maxArea, height * 2);

        // 양쪽으로 확장하면서 최대 면적을 갱신합니다.
        while (left < l || r < right) {
            // 오른쪽으로 확장할 수 있고, 왼쪽 확장이 불가능하거나 오른쪽 확장이 더 높은 경우
            if (r < right && (l == left || histogram[l - 1] < histogram[r + 1])) {
                r++;
                height = Math.min(height, histogram[r]);
            } else {
                l--;
                height = Math.min(height, histogram[l]);
            }
            maxArea = Math.max(maxArea, height * (r - l + 1));
        }

        return maxArea;
    }
}