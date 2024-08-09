import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] diff = new int[N - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        int gcdNum = diff[0];
        for (int i = 1; i < diff.length; i++) {
            gcdNum = gcd(gcdNum, diff[i]);
        }
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i] / gcdNum - 1;
        }
        System.out.print(sum);
    }

    static int gcd(int A, int B) {
        while(B != 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}