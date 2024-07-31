import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        // Base64 문자 집합과 인덱스 매핑
        Map<Character, Integer> map = new HashMap<>();
        String base64Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        for (int i = 0; i < base64Chars.length(); i++) {
            map.put(base64Chars.charAt(i), i);
        }

        for (int test_case = 1; test_case <= T; test_case++) {
            String encodedStr = br.readLine();
            StringBuilder binaryStr = new StringBuilder();

            // Base64 문자들을 6비트 바이너리 값으로 변환
            for (int i = 0; i < encodedStr.length(); i++) {
                int value = map.get(encodedStr.charAt(i));
                String binarySegment = String.format("%6s", Integer.toString(value, 2)).replace(' ', '0');
                binaryStr.append(binarySegment);
            }

            StringBuilder decodedStr = new StringBuilder();
            // 8비트씩 잘라서 원래의 문자로 변환
            for (int i = 0; i <= binaryStr.length() - 8; i += 8) {
                String byteStr = binaryStr.substring(i, i + 8);
                char decodedChar = (char) Integer.parseInt(byteStr, 2);
                decodedStr.append(decodedChar);
            }
            System.out.println("#" + test_case + " " + decodedStr.toString());
        }
    }
}