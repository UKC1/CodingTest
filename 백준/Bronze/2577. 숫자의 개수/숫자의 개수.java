import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10];
        int mul = 1;
        for (int i = 0; i < 3; i++) {
            mul *= Integer.parseInt(br.readLine());
        }

        while (mul > 0) {
            arr[mul % 10]++;
            mul /= 10;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}