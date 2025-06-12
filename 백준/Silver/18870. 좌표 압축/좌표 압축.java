import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // O(N) 문제
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // 나보다 작은 애들의 개수를 구해야 됨
        // 제일 작은애가 0등
        int[] sortedNumbers = Arrays.copyOf(numbers, N);
        Arrays.sort(sortedNumbers);
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sortedNumbers[0], rank);
        for (int i = 1; i < N; i++) {
            if (sortedNumbers[i - 1] == sortedNumbers[i]) {
                continue;
            }
            map.put(sortedNumbers[i], ++rank);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(numbers[i])).append(' ');
        }
        System.out.print(sb);

    }
}

