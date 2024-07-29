import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String INVALID = "Invalid";
    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            String[] triangle = str.split(" ");
            int firstLen = Integer.parseInt(triangle[0]);
            int secondLen = Integer.parseInt(triangle[1]);
            int thirdLen = Integer.parseInt(triangle[2]);

            // 종료 조건
            if (firstLen == 0 && secondLen == 0 && thirdLen == 0) {
                break;
            }

            // 삼각형 판별 및 출력
            System.out.println(determineTriangleType(firstLen, secondLen, thirdLen));
        }
    }

    private static String determineTriangleType(int a, int b, int c) {
        // 삼각형 불가능한 조건
        int maxLen = Math.max(a, Math.max(b, c));
        if (a + b + c - maxLen <= maxLen) {
            return INVALID;
        }

        // 삼각형 유형 판별
        if (a == b && b == c) {
            return EQUILATERAL;
        } else if (a != b && b != c && c != a) {
            return SCALENE;
        } else {
            return ISOSCELES;
        }
    }
}
