import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int boxSize = Integer.parseInt(st.nextToken());
        int[] box = new int[boxSize + 1];
        for (int i = 1; i <= boxSize; i++) {
            box[i] = i;
        }
        int eventNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < eventNum; i++) {
            st = new StringTokenizer(br.readLine());
            int swapOneNum = Integer.parseInt(st.nextToken());
            int swapTwoNum = Integer.parseInt(st.nextToken());

            int tmp = box[swapOneNum];
            box[swapOneNum] = box[swapTwoNum];
            box[swapTwoNum] = tmp;
        }

        for (int i = 1; i < box.length; i++) {
            System.out.print(box[i] + " ");
        }

    }
}