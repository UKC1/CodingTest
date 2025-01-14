import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] group1 = new int[N + 1];
        int[] group2 = new int[M + 1];

        int minIndex1 = 1, minValue1 = Integer.MAX_VALUE;
        int minIndex2 = 1, minValue2 = Integer.MAX_VALUE;

        // Group 1 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            group1[i] = Integer.parseInt(st.nextToken());
            if (group1[i] < minValue1 || (group1[i] == minValue1 && i < minIndex1)) {
                minValue1 = group1[i];
                minIndex1 = i;
            }
        }

        // Group 2 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            group2[i] = Integer.parseInt(st.nextToken());
            if (group2[i] < minValue2 || (group2[i] == minValue2 && i + N < minIndex2)) {
                minValue2 = group2[i];
                minIndex2 = i + N;
            }
        }

        // 명령 처리
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            if (cmd == 'U') {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x > N) { // Group 2 Update
                    group2[x - N] = y;

                    if (x == minIndex2 || y < minValue2 || (y == minValue2 && x < minIndex2)) {
                        // 최소값 갱신 필요
                        minValue2 = Integer.MAX_VALUE;
                        for (int j = 1; j <= M; j++) {
                            if (group2[j] < minValue2 || (group2[j] == minValue2 && j + N < minIndex2)) {
                                minValue2 = group2[j];
                                minIndex2 = j + N;
                            }
                        }
                    }
                } else { // Group 1 Update
                    group1[x] = y;

                    if (x == minIndex1 || y < minValue1 || (y == minValue1 && x < minIndex1)) {
                        // 최소값 갱신 필요
                        minValue1 = Integer.MAX_VALUE;
                        for (int j = 1; j <= N; j++) {
                            if (group1[j] < minValue1 || (group1[j] == minValue1 && j < minIndex1)) {
                                minValue1 = group1[j];
                                minIndex1 = j;
                            }
                        }
                    }
                }
            } else { // 명령어 L
                sb.append(minIndex1).append(' ').append(minIndex2).append('\n');
            }
        }

        System.out.print(sb);
    }
}