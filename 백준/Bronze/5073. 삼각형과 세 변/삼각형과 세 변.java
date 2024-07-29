import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!= null) {
            String[] triangle = str.split(" ");
            int firstLen = Integer.parseInt(triangle[0]);
            int secondLen = Integer.parseInt(triangle[1]);
            int thirdLen = Integer.parseInt(triangle[2]);

            if (firstLen == 0 && secondLen == 0 & thirdLen == 0) {
                break;
            }

            int maxLen = Math.max(firstLen, Math.max(secondLen, thirdLen));
            if (firstLen + secondLen + thirdLen - maxLen <= maxLen) {
                System.out.println("Invalid");
            } else {
                if (firstLen == secondLen && secondLen == thirdLen) {
                    System.out.println("Equilateral");
                } else if (firstLen != secondLen && secondLen != thirdLen && thirdLen != firstLen) {
                    System.out.println("Scalene");
                } else {
                    System.out.println("Isosceles");
                }
            }
        }
    }
}
