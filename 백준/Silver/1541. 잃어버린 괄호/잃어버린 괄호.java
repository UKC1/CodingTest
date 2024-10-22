import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("-");

        int minSum = 0;

        // 첫 번째 그룹은 더하고, 이후 그룹은 빼기
        for (int i = 0; i < minus.length; i++) {
            int sum = 0;
            String[] plus = minus[i].split("\\+");  // "+"로 분리하여 합 계산
            for (String num : plus) {
                sum += Integer.parseInt(num);
            }

            // 첫 번째 그룹은 더하고, 나머지는 빼기
            if (i == 0) {
                minSum += sum;
            } else {
                minSum -= sum;
            }
        }

        System.out.println(minSum);
    }
}