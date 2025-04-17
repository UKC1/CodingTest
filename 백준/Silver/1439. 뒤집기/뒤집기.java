import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 0 구간
        // 1 구간
        int totalZeroCnt = 0;
        int totalOneCnt = 0;

        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeroCnt++;
                if (oneCnt != 0) {
                    totalOneCnt++;
                    oneCnt = 0;
                }

            } else if (str.charAt(i) == '1') {
                oneCnt++;
                if (zeroCnt != 0) {
                    totalZeroCnt++;
                    zeroCnt = 0;
                }
            }
        }

        if (zeroCnt != 0) {
            totalZeroCnt++;
        }

        if (oneCnt != 0) {
            totalOneCnt++;
        }
        System.out.print(Math.min(totalOneCnt, totalZeroCnt));
    }
}
