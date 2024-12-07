import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] persons = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            persons[i][0] = weight;
            persons[i][1] = height;
            persons[i][2] = 1;
        }

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && persons[i][0] > persons[j][0] && persons[i][1] > persons[j][1]) {
                    persons[j][2]++;
                }
            }
            visited[i] = false;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(persons[i][2] + " ");
        }
    }
}