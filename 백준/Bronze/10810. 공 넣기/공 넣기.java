import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int boxSize = Integer.parseInt(st.nextToken());
        int ballCount = Integer.parseInt(st.nextToken());
        int[] box = new int[boxSize + 1];
        for (int i = 1; i <= ballCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ballNum = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                box[j] = ballNum;
            }
        }

        for (int i = 1; i <= boxSize; i++) {
            System.out.print(box[i] + " ");
        }
    }
}