import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            Queue<String> firstQueue = new LinkedList<>();
            Queue<String> secondQueue = new LinkedList<>();
            int len = N % 2 == 0 ? N / 2 : N / 2 + 1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                firstQueue.offer(st.nextToken());
            }

            for (int i = len; i < N; i++) {
                secondQueue.offer(st.nextToken());
            }

            System.out.print("#" + test_case);
            while(!secondQueue.isEmpty()) {
                System.out.print(" " + firstQueue.poll());
                System.out.print(" " + secondQueue.poll());
            }

            while(!firstQueue.isEmpty()) {
                System.out.print(" " + firstQueue.poll());
            }
            System.out.println();
        }
    }
}