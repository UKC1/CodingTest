import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nominator1 = Integer.parseInt(st.nextToken());
        int deNominator1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int nominator2 = Integer.parseInt(st.nextToken());
        int deNominator2 = Integer.parseInt(st.nextToken());

        int deNom = lcm(deNominator1, deNominator2);
        int nom = deNom / deNominator1 * nominator1 + deNom / deNominator2 * nominator2;
        int finalGcd = gcd(nom, deNom);
        nom /= finalGcd;
        deNom /= finalGcd;
        System.out.print(nom + " " + deNom);
    }

    static int gcd (int A, int B) {
        if (A % B == 0) {
            return B;
        }
        return gcd(B, A % B);
    }

    static int lcm (int A, int B) {
        return A * B / gcd(A, B);
    }
}