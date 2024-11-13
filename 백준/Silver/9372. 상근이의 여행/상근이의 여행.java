import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // N개의 국가를 모두 연결하는 데 필요한 최소 비행 횟수는 N - 1
            sb.append(N - 1).append('\n');

            // M개의 간선 정보를 읽기만 하고 처리하지 않음
            for (int i = 0; i < M; i++) {
                br.readLine(); // 간선 정보는 무시
            }
        }
        System.out.print(sb);
    }
}