import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] box = new int[N + 1];
        for (int i = 1; i < box.length; i++) {
            box[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= (start + end) / 2; j++) {
                int temp = box[j];
                box[j] = box[end + start - j];
                box[end + start - j] = temp;
            }
        }

        for (int i = 1; i < box.length; i++) {
            System.out.print(box[i] + " ");
        }

    }
}