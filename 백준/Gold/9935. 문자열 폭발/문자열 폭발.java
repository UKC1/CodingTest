import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explode = br.readLine();
        int len = explode.length();

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= len && sb.substring(sb.length() - len).equals(explode)) {
                sb.delete(sb.length() - len, sb.length());
            }
        }

        System.out.print(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}